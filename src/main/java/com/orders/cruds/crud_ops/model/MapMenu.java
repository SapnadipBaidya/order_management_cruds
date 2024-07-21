package com.orders.cruds.crud_ops.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "map_menu")
public class MapMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Integer mapLayoutId;
	@Column(name = "priority_id")
	private Integer layoutName;
	@Column(name =  "component_path")
	private String componentPath;
	@Column(name =  "component_route")
	private String componentRoute;
	@ManyToOne
	@JoinColumn(name = "fk_menu_id")
	private LuMenu fkMenuId;
	@ManyToOne
	@JoinColumn(name = "fk_datatype_id")
	private DataType fkDataTypeId;
	
	
	public Integer getMapLayoutId() {
		return mapLayoutId;
	}
	public void setMapLayoutId(Integer mapLayoutId) {
		this.mapLayoutId = mapLayoutId;
	}
	public Integer getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(Integer layoutName) {
		this.layoutName = layoutName;
	}
	public LuMenu getFkMenuId() {
		return fkMenuId;
	}
	public void setFkMenuId(LuMenu fkMenuId) {
		this.fkMenuId = fkMenuId;
	}
	public DataType getFkDataTypeId() {
		return fkDataTypeId;
	}
	public void setFkDataTypeId(DataType fkDataTypeId) {
		this.fkDataTypeId = fkDataTypeId;
	}
	public String getComponentPath() {
		return componentPath;
	}
	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}
	public String getComponentRoute() {
		return componentRoute;
	}
	public void setComponentRoute(String componentRoute) {
		this.componentRoute = componentRoute;
	}
}
