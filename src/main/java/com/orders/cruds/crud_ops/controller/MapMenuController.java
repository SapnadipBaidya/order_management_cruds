package com.orders.cruds.crud_ops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.cruds.crud_ops.model.MapMenu;
import com.orders.cruds.crud_ops.service.MapMenuService;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*")
public class MapMenuController {
	@Autowired
	private MapMenuService mapMenuService;

	@GetMapping("/{dataTypeName}-{parentMenuId}")
	public List<MapMenu> findMappedMapped(@PathVariable String dataTypeName, @PathVariable Integer parentMenuId) {
		try {
			System.out.println(dataTypeName+" "+parentMenuId);
			return mapMenuService.findMappedMapped(dataTypeName, parentMenuId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
