package com.orders.cruds.crud_ops.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.model.MapMenu;
import com.orders.cruds.crud_ops.repository.impl.MapMenuRepository;
import com.orders.cruds.crud_ops.service.LuFieldService;
import com.orders.cruds.crud_ops.service.MapMenuService;

@Service
public class MapMenuServiceImpl implements MapMenuService {
	private static final Logger logger = LoggerFactory.getLogger(LuFieldService.class);
	@Autowired
	private MapMenuRepository mapMenuRepository;

	@Override
	public List<MapMenu> findMappedMapped(String dataTypeName, Integer parentMenuId) {
		try {
			return mapMenuRepository.findMappedMapped(dataTypeName, parentMenuId);
		} catch (Exception e) {
			logger.error("error is", e);
		}
		return null;

	}

}
