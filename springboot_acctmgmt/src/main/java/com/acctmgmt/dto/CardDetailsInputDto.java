package com.acctmgmt.dto;

import java.sql.Date;

public class CardDetailsInputDto {
	
	private Integer cusid;
	private Integer id;
	private Integer cardnumber;
	private Date expirydate;
	private Integer balance;
	private String status;
	public Integer getCustomerid() {
		return cusid;
	}
	public void setCustomerid(Integer cusid) {
		this.cusid = cusid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(Integer cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
