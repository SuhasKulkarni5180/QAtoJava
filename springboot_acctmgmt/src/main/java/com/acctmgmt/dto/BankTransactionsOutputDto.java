package com.acctmgmt.dto;

import java.util.Date;

public class BankTransactionsOutputDto {
	
	private Long id;
	private Long cusid;
	private Long acctNumber;
	private Double amount;
	private Date date;
	private String transType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCusid() {
		return cusid;
	}
	public void setCusid(Long integer) {
		this.cusid = integer;
	}
	public Long getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(Long acctNumber) {
		this.acctNumber = acctNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	
	

}
