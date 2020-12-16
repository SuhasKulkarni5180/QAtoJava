package com.acctmgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class BankTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;

	private Long Customerid;

	private Long accountNumber;

	private Date createDate;

	private String transType;

	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return Customerid;
	}

	public void setCustId(Long Customerid) {
		this.Customerid = Customerid;
	}

	public Long getAccountId() {
		return accountNumber;
	}

	public void setAccountId(Long acctNumber) {
		this.accountNumber = acctNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BankTransaction [id=" + id + ", custId=" + Customerid + ", accountId=" + accountNumber + ", createDate="
				+ createDate + ", transType=" + transType + ", amount=" + amount + "]";
	}

	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
