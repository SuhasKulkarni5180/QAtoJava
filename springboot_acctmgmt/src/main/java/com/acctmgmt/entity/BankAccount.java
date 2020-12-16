package com.acctmgmt.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long Cusid;
	private String acctType;
	private Double balance;
	private Date createDate;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double amount) {
		this.balance = amount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCusid() {
		return Cusid;
	}
	public void setCusid(Long Cusid) {
		this.Cusid = Cusid;
	}
	
	

}
