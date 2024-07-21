package com.orders.cruds.crud_ops.repository.impl;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.orders.cruds.crud_ops.model.MapMenu;

@org.springframework.stereotype.Repository
public interface MapMenuRepository extends Repository<MapMenu, Integer> {

	final String hqlForGetMappedMenuByDatatypeNameAndParentId = "SELECT mm FROM MapMenu mm "
			+ "JOIN mm.fkDataTypeId dt JOIN mm.fkMenuId lm WHERE dt.dataTypeName = :dataTypeName "
			+ "AND lm.parentMenuId = :parentMenuId";

	@Query(hqlForGetMappedMenuByDatatypeNameAndParentId)
	List<MapMenu> findMappedMapped(@Param("dataTypeName") String dataTypeName,
			@Param("parentMenuId") Integer parentMenuId);

}