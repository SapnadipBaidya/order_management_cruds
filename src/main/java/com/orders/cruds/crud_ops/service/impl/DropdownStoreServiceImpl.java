package com.orders.cruds.crud_ops.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.repository.impl.DropdownStoreRepository;
import com.orders.cruds.crud_ops.service.DropdownStoreService;
import com.orders.cruds.crud_ops.service.GenericQueryService;

@Service
public class DropdownStoreServiceImpl implements DropdownStoreService{
	private static final Logger logger = LoggerFactory.getLogger(DropdownStoreService.class);
	@Autowired
	DropdownStoreRepository dropdownStoreRepository;
	@Autowired
	GenericQueryService genericQueryService;
	@Override
	public List<Map<String,String>> findHQLbyKEY(String storeKey){
		try {
			logger.debug("DropdownStoreService findHQLbyKEY start "+storeKey);
			String HQLquery = dropdownStoreRepository.findHQLbyKEY(storeKey);
			return genericQueryService.executeHqlQuery(HQLquery,null);
		} catch (Exception e) {
			logger.error("error occured in DropdownStoreService "+e);
			return null;
		}
		
	};
}
