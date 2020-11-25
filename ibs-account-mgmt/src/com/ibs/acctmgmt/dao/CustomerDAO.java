package com.ibs.acctmgmt.dao;

import java.util.List;

import com.ibs.acctmgmt.entity.BankAccount;
import com.ibs.acctmgmt.entity.BankTransaction;
import com.ibs.acctmgmt.entity.Customer;
import com.ibs.acctmgmt.entity.Login;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public void createAccount(BankAccount bankAccount);
	
	public Customer getCustomer(int theId);

	public List<BankAccount> getAccountBalances(int i);

	public void saveTrans(BankTransaction bankTransaction);

	public BankAccount getAccountById(int id);

	public List<BankTransaction> getMiniStatement(int i);

	List<BankTransaction> getTrasactionsById(int id);

	public Login login(String usrName);
}
