package com.orders.cruds.crud_ops.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lu_country_currency")
public class LuCountryCurrency {
	@Id
	@Column(name="pk_country_id")
	private Integer pkCountryId;
	@Column(name="country")
	private String country;
	@Column(name="currency_code")
	private String currencyCode;
	@Column(name="currency_symbol")
	private String currencySymbol;
	@Column(name="description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "fk_country_status")
	private LuCountryStatus fkCountryStatus;
	
	public Integer getPkCountryId() {
		return pkCountryId;
	}
	public void setPkCountryId(Integer pkCountryId) {
		this.pkCountryId = pkCountryId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LuCountryStatus getFkCountryStatus() {
		return fkCountryStatus;
	}
	public void setFkCountryStatus(LuCountryStatus fkCountryStatus) {
		this.fkCountryStatus = fkCountryStatus;
	}
}
