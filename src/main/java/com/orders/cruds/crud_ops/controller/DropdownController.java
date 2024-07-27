package com.orders.cruds.crud_ops.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.orders.cruds.crud_ops.service.DropdownStoreService;

@RestController
@RequestMapping("dropdownStore")
@CrossOrigin(origins = "*")
public class DropdownController {
	@Autowired
	DropdownStoreService dropdownStoreService;
	@GetMapping("/dropdownHealthCheck")
	public String dropdownHealthCheck(){
		
		return "ALL OK";
	}
	
	@GetMapping("/findHQLbyKEY/{storeKey}")
	public List<Map<String,String>> findHQLbyKEY(@PathVariable String storeKey){
		System.out.println(storeKey);
		return dropdownStoreService.findHQLbyKEY(storeKey);
	}
}
