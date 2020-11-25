package com.ibs.acctmgmt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibs.acctmgmt.dao.CustomerDAO;
import com.ibs.acctmgmt.entity.BankAccount;
import com.ibs.acctmgmt.entity.BankTransaction;
import com.ibs.acctmgmt.entity.Customer;
import com.ibs.acctmgmt.entity.Login;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void createAccount(BankAccount bankAccount) {
		
		Date dateobj = new Date();
		
		bankAccount.setCustId(100);
		bankAccount.setCreateDate(dateobj);
		bankAccount.setBalance(0.0);
		customerDAO.createAccount(bankAccount);
		
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public List<BankAccount> getAccountBalances() {
		return customerDAO.getAccountBalances(100);
	}


	@Override
	@Transactional
	public void createTrans(BankTransaction bankTransaction) {
		BankAccount account = null;
		
		Date dateobj = new Date();
		if(bankTransaction.getTransType().equals("FD Deposit")) {
			bankTransaction.setAccountId(3);
		}
		else if(bankTransaction.getTransType().equals("RD Deposit")){
			bankTransaction.setAccountId(2);
		}
		else {	
			bankTransaction.setAccountId(1);
		}

		bankTransaction.setCustId(100);
		bankTransaction.setCreateDate(dateobj);
		customerDAO.saveTrans(bankTransaction);

		if(bankTransaction.getTransType().equals("FD Deposit")) {
			 account = customerDAO.getAccountById(3);
			 Double currentBal = account.getBalance();	
			 account.setBalance(currentBal + bankTransaction.getAmount());
		}
		else if(bankTransaction.getTransType().equals("RD Deposit")) {
			 account = customerDAO.getAccountById(2);
			 Double currentBal = account.getBalance();	
			 account.setBalance(currentBal + bankTransaction.getAmount());
			
		}
		else{	
			 account = customerDAO.getAccountById(1);
			 Double currentBal = account.getBalance();	
				if(bankTransaction.getTransType().equals("Credit")) {
					account.setBalance(currentBal + bankTransaction.getAmount());
				}
				else {
					account.setBalance(currentBal - bankTransaction.getAmount());
				}
		}
			
		
		customerDAO.createAccount(account);
	}

	@Override
	@Transactional
	public List<BankTransaction> getMiniStatement(int i) {
		return customerDAO.getMiniStatement(100);
	}


	@Override
	@Transactional
	public List<BankTransaction> getMonthlyStatement(int i, int month) {
		List<BankTransaction> result = new ArrayList<>();
		List<BankTransaction> trans = customerDAO.getTrasactionsById(i);
		
		for(BankTransaction bt : trans) {
			@SuppressWarnings("deprecation")
			int transaMonth = bt.getCreateDate().getMonth();
			if(transaMonth + 1 == month) {
				result.add(bt);
			}
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<BankTransaction> getYearlyStatement(int i, int year) {
		List<BankTransaction> result = new ArrayList<>();
		List<BankTransaction> trans = customerDAO.getTrasactionsById(i);
		
		for(BankTransaction bt : trans) {
			@SuppressWarnings("deprecation")
			int transaYear = bt.getCreateDate().getYear();
			if(transaYear + 1900 == year) {
				result.add(bt);
			}
		}
		return result;
	}

	@Override
	@Transactional
	public String login(String usrName, String pwd) {
		
		Login login = customerDAO.login(usrName);
		
		if(login.getPassword().equals(pwd)) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}





