package com.orders.cruds.crud_ops.model;

import jakarta.persistence.*;

@Entity
public class LuCountryStatus {
	@Id
	@Column(name = "status_id")
	private Integer statusId;
	@Column(name = "status")
	private String status;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
