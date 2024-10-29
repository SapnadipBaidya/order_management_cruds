package com.orders.cruds.crud_ops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.model.FieldType;
import com.orders.cruds.crud_ops.repository.impl.FieldTypeRepository;
import com.orders.cruds.crud_ops.service.FieldTypeService;

@Service
public class FieldTypeServiceImpl implements FieldTypeService{
	@Autowired
    private FieldTypeRepository fieldTypeRepository;

	@Override
	public FieldType findFieldTypeByName(String fieldTypeName) {
		// TODO Auto-generated method stub
		return fieldTypeRepository.findFieldTypeByName(fieldTypeName);
	}

}
