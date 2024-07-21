package com.orders.cruds.crud_ops.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LuField {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Integer fieldId;
	
	@Column(name = "field_name")
    private String fieldName;

    @Column(name = "display_value")
    private String displayValue;

    @ManyToOne
    @JoinColumn(name = "fk_datatype_id")
    private DataType fkDatatypeId;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "create_user")
    private String createUser;

    @ManyToOne
    @JoinColumn(name = "fk_field_type")
    private FieldType fieldType;

    @ManyToOne
    @JoinColumn(name = "fk_field_display_type")
    private FieldDisplayType fieldDisplayType;

    public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public DataType getFkDatatypeId() {
		return fkDatatypeId;
	}

	public void setFkDatatypeId(DataType fkDatatypeId) {
		this.fkDatatypeId = fkDatatypeId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public FieldDisplayType getFieldDisplayType() {
		return fieldDisplayType;
	}

	public void setFieldDisplayType(FieldDisplayType fieldDisplayType) {
		this.fieldDisplayType = fieldDisplayType;
	}


}
