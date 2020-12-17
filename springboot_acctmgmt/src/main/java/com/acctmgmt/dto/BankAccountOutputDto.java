package com.acctmgmt.dto;

public class BankAccountOutputDto {
	
	private Long accountNumber;
	private String accountType;
	private Double balance;
	private Long cusid;



	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long long1) {
		this.accountNumber = long1;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getCusid() {
		return cusid;
	}
	public void setCusid(Long cusid) {
		this.cusid = cusid;
	}
	

}
