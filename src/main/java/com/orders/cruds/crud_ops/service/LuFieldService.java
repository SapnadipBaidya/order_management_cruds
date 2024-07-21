package com.orders.cruds.crud_ops.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.orders.cruds.crud_ops.model.LuField;

public interface LuFieldService {
    List<LuField> findAll();
    Optional<LuField> findById(Integer id);
    LuField save(LuField luField);
    void deleteById(Integer id);
    public void saveFields(List<LuField> luFields);
    List<LuField> findUpdatedAfter(Date updateDate);
	public String getHealth();
}