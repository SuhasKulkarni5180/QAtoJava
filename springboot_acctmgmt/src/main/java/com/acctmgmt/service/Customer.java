package com.acctmgmt.service;


import java.util.List;

import com.acctmgmt.dto.BankAccountOutputDto;
import com.acctmgmt.dto.BankTransactionInputDto;
import com.acctmgmt.dto.BankTransactionsOutputDto;
import com.acctmgmt.dto.CustomerOutputDto;
import com.acctmgmt.dto.UsersOutputDto;
import com.acctmgmt.entity.BankTransaction;
import com.acctmgmt.repository.BankTransactionRepository;

public interface Customer {
	
	
	public BankAccountOutputDto getBalance(int i);


	public List<CustomerOutputDto> getyearlyStatement(Integer cusid, int year);

	public String login(String usrName, String pwd);


	public UsersOutputDto register(String firstname, String lastname, String middlename, String email, String phone);


	public BankAccountOutputDto createNewAccount(String account, String amount, int parseInt);


	public BankTransactionsOutputDto createTrans(Long acctNumber, String transType, Double amount);

	public List<BankTransactionsOutputDto> getminiStatement(Long acctNumber);

	public List<BankTransactionsOutputDto> getmonthlyStatement(Long acct, Integer month);





	

	
	

}
