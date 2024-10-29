package com.orders.cruds.crud_ops.repository.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.orders.cruds.crud_ops.model.FieldType;

@org.springframework.stereotype.Repository
public interface FieldTypeRepository  extends Repository<FieldType, Integer>{

	
	@Query("SELECT ft FROM FieldType ft WHERE ft.fieldTypeName = :fieldTypeName")
	public FieldType findFieldTypeByName(String fieldTypeName);
}


