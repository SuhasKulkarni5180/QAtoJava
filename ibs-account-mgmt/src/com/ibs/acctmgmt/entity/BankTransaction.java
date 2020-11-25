package com.ibs.acctmgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banktransaction")
public class BankTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="trans_type")
	private String transType;
	
	@Column(name="amount")
	private Double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
		return "BankTransaction [id=" + id + ", custId=" + custId + ", accountId=" + accountId + ", createDate="
				+ createDate + ", transType=" + transType + ", amount=" + amount + "]";
	}

	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
