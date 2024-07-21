package com.orders.cruds.crud_ops.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.cruds.crud_ops.model.LuField;
import com.orders.cruds.crud_ops.repository.impl.LuFieldRepository;
import com.orders.cruds.crud_ops.service.LuFieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LuFieldServiceImpl implements LuFieldService {
	private static final Logger logger = LoggerFactory.getLogger(LuFieldService.class);
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
			System.out.println(field.getDisplayValue());
			System.out.println(field.getFkDatatypeId());
			System.out.println(field.getFieldDisplayType());
			luFieldRepository.save(field);
		});
	}

}