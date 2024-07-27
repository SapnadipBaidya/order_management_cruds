package com.orders.cruds.crud_ops.service;

import java.util.List;
import java.util.Map;

public interface GenericQueryService {
	public List<Map<String,String>> executeHqlQuery(String hql, Map<String, Object> parameters);
}
