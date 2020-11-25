package com.ibs.acctmgmt.service;

import java.util.List;

import com.ibs.acctmgmt.entity.BankAccount;
import com.ibs.acctmgmt.entity.BankTransaction;
import com.ibs.acctmgmt.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public void createAccount(BankAccount bankAccount);
	
	public Customer getCustomer(int theId);


	public List<BankAccount> getAccountBalances();

	public void createTrans(BankTransaction bankTransaction);

	public List<BankTransaction> getMiniStatement(int i);

	public List<BankTransaction> getMonthlyStatement(int i, int j);

	List<BankTransaction> getYearlyStatement(int i, int year);

	public String login(String usrName, String pwd);
}
