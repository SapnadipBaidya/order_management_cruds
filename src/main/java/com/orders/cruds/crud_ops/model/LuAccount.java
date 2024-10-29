package com.orders.cruds.crud_ops.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LuAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public LuCountryCurrency getFkCountryId() {
		return fkCountryId;
	}
	public void setFkCountryId(LuCountryCurrency fkCountryId) {
		this.fkCountryId = fkCountryId;
	}
	@Column(name = "account_name")
    private String accountName;
	@ManyToOne
	@JoinColumn(name = "fk_country_id")
	private LuCountryCurrency fkCountryId;

}