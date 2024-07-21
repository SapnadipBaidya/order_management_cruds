package com.orders.cruds.crud_ops.model;

import jakarta.persistence.*;

@Entity
@Table(name = "field_display_type")
public class FieldDisplayType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_display_id")
    private Integer fieldDisplayId;

    @Column(name = "field_display_type_name")
    private String fieldDisplayTypeName;

	public Integer getFieldDisplayId() {
		return fieldDisplayId;
	}

	public void setFieldDisplayId(Integer fieldDisplayId) {
		this.fieldDisplayId = fieldDisplayId;
	}

	public String getFieldDisplayTypeName() {
		return fieldDisplayTypeName;
	}

	public void setFieldDisplayTypeName(String fieldDisplayTypeName) {
		this.fieldDisplayTypeName = fieldDisplayTypeName;
	}

    // Getters and Setters
    // ... (include all getters and setters here)
}
