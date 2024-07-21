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
@Table(name = "map_lu_layout")
public class MapLuLayout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "map_layout_id")
	private Integer mapLayoutId;
	@Column(name = "layout_name")
	private Integer layoutName;
	@ManyToOne
	@JoinColumn(name = "fk_datatype_id")
	private DataType fkDataTypeId;
	@ManyToOne
	@JoinColumn(name = "fk_layout_id")
	private LuLayout fkLayoutId;
	@Column(name = "layout_csv")
	private Integer layoutCsv;

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

	public DataType getFkDataTypeId() {
		return fkDataTypeId;
	}

	public void setFkDataTypeId(DataType fkDataTypeId) {
		this.fkDataTypeId = fkDataTypeId;
	}

	public LuLayout getFkLayoutId() {
		return fkLayoutId;
	}

	public void setFkLayoutId(LuLayout fkLayoutId) {
		this.fkLayoutId = fkLayoutId;
	}

	public Integer getLayoutCsv() {
		return layoutCsv;
	}

	public void setLayoutCsv(Integer layoutCsv) {
		this.layoutCsv = layoutCsv;
	}

}
