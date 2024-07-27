package com.orders.cruds.crud_ops.service;


import java.util.List;
import java.util.Map;

public interface DropdownStoreService {
	public List<Map<String,String>> findHQLbyKEY(String storeKey);
}
