package com.orders.cruds.crud_ops.controller;

import java.util.List;

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
	public List<?> findHQLbyKEY(@PathVariable String storeKey){
		System.out.println(storeKey);
		return dropdownStoreService.findHQLbyKEY(storeKey);
	}
}
