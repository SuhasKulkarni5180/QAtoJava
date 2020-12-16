package com.acctmgmt.dto;

public class BankTransactionInputDto {
	
	private Integer customerid;
	private Integer accountid;
	private Integer account_number;
	private Double amount;
	private String transtype;
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public Integer getAccount_number() {
		return account_number;
	}
	public void setAccount_number(Integer account_number) {
		this.account_number = account_number;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	
	
	
	
	

}
