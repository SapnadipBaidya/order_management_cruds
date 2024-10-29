package com.orders.cruds.crud_ops.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.model.DataType;
import com.orders.cruds.crud_ops.model.FieldType;
import com.orders.cruds.crud_ops.model.LuAccount;
import com.orders.cruds.crud_ops.model.LuField;
import com.orders.cruds.crud_ops.repository.impl.LuFieldRepository;
import com.orders.cruds.crud_ops.service.FieldTypeService;
import com.orders.cruds.crud_ops.service.LuFieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LuFieldServiceImpl implements LuFieldService {
	@Autowired
    private FieldTypeService fieldTypeService;
	@Autowired
	private LuFieldRepository luFieldRepository;

	@Override
	public String getHealth() {
		return "hulla";
	}

	@Override
	public List<LuField> findAll() {
		return luFieldRepository.findAll();
	}

	@Override
	public Optional<LuField> findById(Integer id) {
		return luFieldRepository.findById(id);
	}

	@Override
	public LuField save(LuField luField) {
		return luFieldRepository.save(luField);
	}
	
	@Override
	public void deleteById(Integer id) {
		luFieldRepository.deleteById(id);
	}

	@Override
	public List<LuField> findUpdatedAfter(Date updateDate) {
		return luFieldRepository.findUpdatedAfter(updateDate);
	}

	@Override
	public void saveFields(List<LuField> luFields) {
		System.out.println("hereeee");
		luFields.forEach(field -> {
			System.out.println(field.getDisplayText());
			System.out.println(field.getFkDatatypeId());
			System.out.println(field.getFieldDisplayType());
			luFieldRepository.save(field);
		});
	}
	
	@Override
	public List<LuField> findByDataTypeAndAccountId(Integer fkDatatypeId , Integer fkAccountId){
		DataType d = new DataType();
		d.setDataTypeId(fkDatatypeId);
		
		LuAccount l = new LuAccount();
		l.setAccountId(fkAccountId);
		return luFieldRepository.findByDataTypeAndAccountId(d,l);
	}
	
	@Override
    public void setFieldType(LuField luField, String fieldTypeName) {
	      FieldType fieldTypeEntity = fieldTypeService.findFieldTypeByName(fieldTypeName);
	      luField.setFkFieldType(fieldTypeEntity);
	}

}