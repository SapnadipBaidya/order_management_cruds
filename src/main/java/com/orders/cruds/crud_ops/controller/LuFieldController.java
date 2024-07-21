package com.orders.cruds.crud_ops.controller;


import com.orders.cruds.crud_ops.model.LuField;
import com.orders.cruds.crud_ops.service.LuFieldService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/lu-fields")
@CrossOrigin(origins = "*")
public class LuFieldController {

    @Autowired
    private LuFieldService luFieldService;


    @GetMapping
    public String getHealth() {
    	return luFieldService.getHealth();
    }
    @GetMapping("/getAll")
    public List<LuField> findAll() {
        return luFieldService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<LuField> findById(@PathVariable Integer id) {
        return luFieldService.findById(id);
    }
    @GetMapping("/updated-after")
    public List<LuField> findUpdatedAfter(@RequestParam("date") Date updateDate) {
        return luFieldService.findUpdatedAfter(updateDate);
    }
    @PostMapping("/saveFields")
    public ResponseEntity<?> saveFields(@RequestBody List<LuField> luFields) {
        try {
            luFieldService.saveFields(luFields);
            return ResponseEntity.ok("Fields saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving fields");
        }
    }
    
    
}
