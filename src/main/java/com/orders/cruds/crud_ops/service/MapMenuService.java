package com.orders.cruds.crud_ops.service;

import java.util.List;


import com.orders.cruds.crud_ops.model.MapMenu;


public interface MapMenuService {
	 List<MapMenu> findMappedMapped(String dataTypeName ,Integer parentMenuId);
}
