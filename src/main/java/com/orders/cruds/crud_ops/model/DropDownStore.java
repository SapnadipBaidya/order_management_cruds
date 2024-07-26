package com.orders.cruds.crud_ops.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drop_down_store")
public class DropDownStore {
	@Id
	@Column(name = "store_key")
	private String storeKey;
	@Column(name = "store_value")
	private String storeValue;
	public String getStoreKey() {
		return storeKey;
	}
	public void setStoreKey(String storeKey) {
		this.storeKey = storeKey;
	}
	public String getStoreValue() {
		return storeValue;
	}
	public void setStoreValue(String storeValue) {
		this.storeValue = storeValue;
	}
}
