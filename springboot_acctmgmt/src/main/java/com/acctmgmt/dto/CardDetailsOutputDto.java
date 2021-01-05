package com.acctmgmt.dto;

import java.sql.Date;

public class CardDetailsOutputDto {
	
	private Long cusid;
	private Long id;
	private Long cardnumber;
	private Date expirydate;
	private Double balance;
	private String status;
	public Long getCusid() {
		return cusid;
	}
	public void setCusid(Long cusid) {
		this.cusid = cusid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(Long cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(java.util.Date date) {
		this.expirydate = (Date) date;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
