package com.acctmgmt.service;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.acctmgmt.dto.BankAccountOutputDto;
import com.acctmgmt.dto.BankTransactionInputDto;
import com.acctmgmt.dto.BankTransactionsOutputDto;

import com.acctmgmt.dto.UsersOutputDto;
import com.acctmgmt.entity.BankAccount;
import com.acctmgmt.entity.BankTransaction;
import com.acctmgmt.entity.Users;
import com.acctmgmt.repository.BankAccountRepository;
import com.acctmgmt.repository.BankTransactionRepository;

import com.acctmgmt.repository.UsersRepository;





@Component
public class CustomerImpl implements Customer{
	
	@Autowired
	private BankTransactionRepository repository;
	
	
	@Autowired
	private UsersRepository userservice;
	
	@Autowired
	private BankAccountRepository bankaccountservice;

	
	//utility classes
	/*
	private CustomerOutputDto convertEntityToOutputBankAccountDto(BankAccount acctdetails) {
		
		CustomerOutputDto customerOutputDto = new CustomerOutputDto();
		
		customerOutputDto.setAcctNumber(acctdetails.getAcctNumber());
		customerOutputDto.setFirstName(acctdetails.getFirstName());
		customerOutputDto.setAcctType(acctdetails.getAcctType());
		customerOutputDto.setLastName(acctdetails.getLastName());
		customerOutputDto.setCreateDate(acctdetails.getCreateDate());
		customerOutputDto.setBalance(acctdetails.getBalance());
		
		return customerOutputDto;
	
	}
	*/


	
	private UsersOutputDto convertToUserOutputDto(Users user){
		
		UsersOutputDto output = new UsersOutputDto();
		output.setUsername(user.getUserName());
		output.setPassword(user.getPassword());
		output.setId(user.getId());
	
		return output;
	}
	

	
	private Users convertToUserInputDto(String firstname, String lastname, String middlename, String email, String phone) {
		Users user = new Users();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setMiddleName(middlename);
		user.setEmail(email);
		user.setMobile(phone);
		user.setUserName(firstname.substring(0,4));
		user.setPassword(firstname.substring(0,4)+phone.substring(0,4));
		user.setRole("customer");
	
		return user;
		
		
	}
	private BankAccount convertToBankAccountInputDto(String account,String amount,int cusid) {
		
		BankAccount acc = new BankAccount();
		Double d = Double.parseDouble(amount);
		acc.setBalance(d);
		acc.setAcctType(account);
		acc.setCusid((long) cusid);
		return acc;
		
	}
	
	private BankAccountOutputDto convertEntityToOutputBankAccountDto(BankAccount accountOutputDto) {
		
		BankAccountOutputDto output = new BankAccountOutputDto();
		output.setAccountNumber(accountOutputDto.getId());
		output.setAccountType(accountOutputDto.getAcctType());
		output.setBalance(accountOutputDto.getBalance());
		output.setCusid(accountOutputDto.getCusid());
		
		return output;
		
	}
	
	private BankTransaction convertToBankTransactionsInputDto(Long acctNumber,String transType, Double amount) {
		
		BankTransaction trans = new BankTransaction();
		BankAccount a=this.bankaccountservice.findByacctNumber(acctNumber);
		Date dateobj = new Date();
		trans.setCreateDate(dateobj);
		trans.setAccountId(acctNumber);
		trans.setAmount(amount);
		trans.setTransType(transType);
		trans.setCustId(a.getCusid());	
		
		return trans;
		
	}
	
	private BankTransactionsOutputDto converToBankTransactionOutputDto(BankTransaction trans) {
		
		BankTransactionsOutputDto transaction = new BankTransactionsOutputDto();
		transaction.setAcctNumber(trans.getAccountId());
		transaction.setAmount(trans.getAmount());
		transaction.setCusid(trans.getCustId());
		transaction.setTransType(trans.getTransType());
		transaction.setDate(trans.getCreateDate());
		transaction.setId(trans.getId());
		return transaction;
		
		
	}
	
	private BankAccount convertToBankAccountBalanceDto(Long acctNumber, Double amount) {
		
		BankAccount bal = new BankAccount();
		bal.setBalance(amount);
		return bal;
		
	}
	
	
	
	@Override
	@Transactional
	public BankAccountOutputDto getBalance(int acctnumber){
		//return type would be of entity type BankAccount
		
		
		BankAccount acct = this.bankaccountservice.findById((long) acctnumber).orElse(null);
	
		BankAccountOutputDto bankAccountDto	= this.convertEntityToOutputBankAccountDto(acct);

		return bankAccountDto;
	}


	@Override
	@Transactional
	public List<BankTransactionsOutputDto> getminiStatement(Long acctNumber) {
		
		
		List<BankTransactionsOutputDto> bankTransactionOutputDtos = new ArrayList<BankTransactionsOutputDto>();
		List<BankTransaction> mini = this.repository.findByAccountNumber(acctNumber);
	
		
		for(BankTransaction ministatement : mini) {
			BankTransactionsOutputDto bankTransaction = this.converToBankTransactionOutputDto(ministatement);
			bankTransactionOutputDtos.add(bankTransaction);
		}
		bankTransactionOutputDtos= bankTransactionOutputDtos.subList(7,1);
		
		return bankTransactionOutputDtos;
	}

	@Override
	public List<BankTransactionsOutputDto> getmonthlyStatement(Long acct,Integer month) {
		
			List<BankTransactionsOutputDto> bankTransactionOutputDtos = new ArrayList<>();
			List<BankTransaction> monthly=this.repository.findByAccountNumber(acct);
			
			for(BankTransaction bt :monthly ) {
			@SuppressWarnings("deprecation")
			int transmonth = bt.getCreateDate().getMonth();
			if(transmonth+1 == month) {
				BankTransactionsOutputDto bankTrans = this.converToBankTransactionOutputDto(bt);
				bankTransactionOutputDtos.add(bankTrans);
				
			}
			
			}
	
		return customerOutputDtos;
	}

	@Override
	@Transactional
	public List<CustomerOutputDto> getyearlyStatement(Integer cusid, int year) {
		List<CustomerOutputDto> customerOutputDtos = new ArrayList<>();
		List<BankTransaction> yearly=repository.findByCustomerid(cusid);
		
		for(BankTransaction bt : yearly) {
			@SuppressWarnings("deprecation")
			int transaYear = bt.getCreateDate().getYear();
			if(transaYear + 1900 == year) {
				CustomerOutputDto customerOutputDto = this.convertEntityToOutputDto(bt);
				customerOutputDtos.add(customerOutputDto);
			}
		}
		return customerOutputDtos;
	
	}
	
	@Override
	@Transactional
	public String login(String usrName, String pwd) {
		
		Users user = userservice.findByUserName(usrName,pwd);
		UsersOutputDto olduser =this.convertToUserOutputDto(user);
		
		
		if((olduser.getUsername()).equals(usrName)&&(olduser.getPassword().equals(pwd))){	
			
			return "success";
		}else if((olduser.getUsername()).equals(null)&&(olduser.getPassword().equals(null))) {
			
			return "failure";
		} else {
			
			return "failure";
		}
	
	}



	@Override
	public UsersOutputDto register(String firstname, String lastname, String middlename, String email, String phone) {
		
		Users newUser= this.convertToUserInputDto(firstname,lastname,middlename,email,phone);
		Users registered=this.userservice.save(newUser);
		UsersOutputDto userOutputDto = this.convertToUserOutputDto(registered);
		
		return userOutputDto;
	}



	@Override
	@Transactional
	public BankAccountOutputDto createNewAccount(String account, String amount, int cusid) {
		// TODO Auto-generated method stub
		
		BankAccount newAccount = this.convertToBankAccountInputDto(account, amount,cusid);
		BankAccount accountOutputDto= this.bankaccountservice.save(newAccount);
		
		BankAccountOutputDto bankAccountOutputDto =this.convertEntityToOutputBankAccountDto(accountOutputDto);
		
		
		return bankAccountOutputDto;
	}


	@Override
	@Transactional
	public BankTransactionsOutputDto createTrans(Long acctNumber,String transType, Double amount) {
		BankAccount account = this.bankaccountservice.findByacctNumber(acctNumber);
		BankTransaction newTransaction =this.convertToBankTransactionsInputDto(acctNumber,transType, amount);
		BankTransaction trans= this.repository.save(newTransaction);
		
		Double currentbal = account.getBalance();
		if(trans.getTransType().equals("Deposit")) {
			
			account.setBalance(currentbal+newTransaction.getAmount());
			Double acc=account.getBalance();
			BankAccount bal = this.convertToBankAccountBalanceDto(acctNumber, amount);
			this.bankaccountservice.updateBalance(acc,acctNumber);
			
		}else {
			account.setBalance(currentbal-newTransaction.getAmount());
			Double acc=account.getBalance();
			BankAccount bal = this.convertToBankAccountBalanceDto(acctNumber, amount);
			this.bankaccountservice.updateBalance(acc,acctNumber);
		}
		BankTransactionsOutputDto bankTransOutputDto = this.converToBankTransactionOutputDto(trans); 
		

		return bankTransOutputDto;
	}

	
	


}
