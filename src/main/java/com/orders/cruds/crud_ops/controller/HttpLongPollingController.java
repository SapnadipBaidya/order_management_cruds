package com.orders.cruds.crud_ops.controller;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.orders.cruds.crud_ops.model.DataType;
import com.orders.cruds.crud_ops.model.LuAccount;
import com.orders.cruds.crud_ops.model.LuField;
import com.orders.cruds.crud_ops.service.LuFieldService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/polling")
@CrossOrigin(origins = "*")
public class HttpLongPollingController {
    @Autowired
    private LuFieldService luFieldService;
    
    private volatile List<LuField> latestItems = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition newDataAvailable = lock.newCondition();

    @PostConstruct
    public void init() {
        latestItems = luFieldService.findByDataTypeAndAccountId(1, -1);
    }

    @PostMapping("/saveOrderFormFields")
    public ResponseEntity<String> saveItems(@RequestBody List<List<Object>> items) {
        List<LuField> savedItems = new ArrayList<>();
        List<String> incomingFieldIds = new ArrayList<>();

        items.forEach(item -> {
            String fieldName = (String) item.get(0);
            Map<String, Object> fieldDetails = (Map<String, Object>) item.get(1);

            LuField luField = new LuField();
            LuAccount la = new LuAccount();
            la.setAccountId(-1);
            DataType dt = new DataType();
            dt.setDataTypeId(1);

            luField.setFieldName(fieldName);
            luField.setDisplayText((String) fieldDetails.get("displayText"));
            luField.setFkDatatypeId(dt);
            luField.setFkAccountId(la);
            luFieldService.setFieldType(luField, (String) fieldDetails.get("fieldType"));
            incomingFieldIds.add(fieldName);

            if (fieldDetails.get("fieldId") != null) {
                Integer fieldId = (Integer) fieldDetails.get("fieldId");
                luField.setFieldId(fieldId);
                luField.setUpdateDate(new Date());
                System.out.println("Updating field ID: " + fieldId);
            } else {
                luField.setCreateDate(new Date());
                System.out.println("Creating new field");
            }

            luFieldService.save(luField);
            savedItems.add(luField);
        });

        List<LuField> allFields = luFieldService.findByDataTypeAndAccountId(1, -1);
        allFields.forEach(field -> {
            if (!incomingFieldIds.isEmpty() && !incomingFieldIds.contains(field.getFieldName())) {
                luFieldService.deleteById(field.getFieldId());
                System.out.println("Deleting field ID: " + field.getFieldId());
            }
        });

        // Notify waiting threads that new data is available
        lock.lock();
        try {
            latestItems = savedItems;
            newDataAvailable.signalAll();
        } finally {
            lock.unlock();
        }
        return ResponseEntity.ok("Order form fields saved/updated successfully, and obsolete fields deleted.");
    }

    @GetMapping("/getOrderFormFields")
    public ResponseEntity<List<Object>> pollItems() throws InterruptedException {
        lock.lock();
        try {
            // Wait until there is new data or timeout occurs
            while (latestItems.isEmpty()) {
                if (!newDataAvailable.await(1, TimeUnit.SECONDS)) {
                    return ResponseEntity.noContent().build(); // Timeout without new data
                }
            }
            List<Object> modifiedItems = new ArrayList<>();

            latestItems.forEach(item -> {
                List<Object> fieldEntry = new ArrayList<>();
                fieldEntry.add(item.getFieldName());
                fieldEntry.add(item);
                modifiedItems.add(fieldEntry);
            });

            latestItems.clear(); // Clear after processing to prevent stale data issues
            return ResponseEntity.ok(modifiedItems);
        } finally {
            lock.unlock();
        }
    }
}
