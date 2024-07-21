package com.orders.cruds.crud_ops.repository.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.orders.cruds.crud_ops.model.LuField;

@org.springframework.stereotype.Repository
public interface LuFieldRepository extends Repository<LuField, Integer> {

	List<LuField> findAll();

	Optional<LuField> findById(Integer id);

	LuField save(LuField luField);

	void deleteById(Integer id);

	@Query("SELECT l FROM LuField l WHERE l.updateDate > :date")
    List<LuField> findUpdatedAfter(@Param("date") Date date);
	
}
