package com.orders.cruds.crud_ops.repository.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.orders.cruds.crud_ops.model.DropDownStore;

@org.springframework.stereotype.Repository
public interface DropdownStoreRepository extends CrudRepository<DropDownStore, String> {

    @Query("SELECT dds.storeValue FROM DropDownStore as dds where dds.storeKey = :storeKey")
    String findHQLbyKEY(@Param("storeKey") String storeKey);
}