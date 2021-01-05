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
import com.acctmgmt.dto.CardDetailsOutputDto;
import com.acctmgmt.dto.NewRegistrationOutputDto;
import com.acctmgmt.dto.UsersOutputDto;
import com.acctmgmt.entity.BankAccount;
import com.acctmgmt.entity.BankTransaction;
import com.acctmgmt.entity.CardDetails;
import com.acctmgmt.entity.NewRegistration;
import com.acctmgmt.entity.Users;
import com.acctmgmt.repository.BankAccountRepository;
import com.acctmgmt.repository.BankTransactionRepository;
import com.acctmgmt.repository.CardsRepository;
import com.acctmgmt.repository.NewRegistrationRepository;
import com.acctmgmt.repository.UsersRepository;


@Component
public class CustomerImpl implements Customer{
	
	@Autowired
	private BankTransactionRepository repository;
	
	
	@Autowired
	private UsersRepository userservice;
	
	@Autowired
	private BankAccountRepository bankaccountservice;
	
	@Autowired
	private NewRegistrationRepository registerservice;
	
	@Autowired
	private CardsRepository cardsservice;

	
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


	
	private NewRegistrationOutputDto convertToNewRegistrationOutputDto(NewRegistration register){
		
		NewRegistrationOutputDto output = new NewRegistrationOutputDto();
		output.setAppId(register.getId());
		output.setFirstname(register.getFirstName());
		Long l =register.getStatus();
		if(l==1) {
			output.setStatus("Not Approved");
		}

	return output;
	}
	

	
	private NewRegistration convertToNewRegistrationInputDto(String firstname, String lastname, String middlename, String email, String phone,String identity) {
		NewRegistration register = new NewRegistration();
		register.setFirstName(firstname);
		register.setLastName(lastname);
		register.setMiddleName(middlename);
		register.setEmail(email);
		register.setMobile(phone);
		//register.setUserName(firstname.substring(0,4));
		//register.setPassword(firstname.substring(0,4)+phone.substring(0,4));
		register.setStatus((long)1);
		register.setIdentity(identity);
		return register;
		
		
	}
	private BankAccount convertToBankAccountInputDto(String account,String amount,int cusid) {
		
		BankAccount acc = new BankAccount();
		Double d = Double.parseDouble(amount);
		Date dateobj = new Date();
		acc.setBalance(d);
		acc.setAcctType(account);
		acc.setCusid((long) cusid);
		acc.setCreateDate(dateobj);
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
	private UsersOutputDto convertToUserOutPutDto(Users user) {
		
		UsersOutputDto login = new UsersOutputDto();
		login.setUsername(user.getUserName());
		login.setPassword(user.getPassword());
		return login;
		
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
			return bankTransactionOutputDtos;
	
	
	}

	@Override
	@Transactional
	public List<BankTransactionsOutputDto> getyearlyStatement(Long acct,Integer year) {
		List<BankTransactionsOutputDto> customerOutputDtos = new ArrayList<>();
		List<BankTransaction> yearly=repository.findByAccountNumber(acct);
		
		for(BankTransaction bt : yearly) {
			@SuppressWarnings("deprecation")
			int transaYear = bt.getCreateDate().getYear();
			if(transaYear + 1900 == year) {
				BankTransactionsOutputDto customerOutputDto = this.converToBankTransactionOutputDto(bt);
				customerOutputDtos.add(customerOutputDto);
			}
		}
		return customerOutputDtos;
	
	}
	
	@Override
	@Transactional
	public String login(String usrName, String pwd) {
		
		Users user = userservice.findByUserName(usrName,pwd);
		UsersOutputDto olduser =this.convertToUserOutPutDto(user);

		if((olduser.getUsername()).equals(usrName)&&(olduser.getPassword().equals(pwd))){	
			
			return "success";
		}else if((olduser.getUsername()).equals(null)&&(olduser.getPassword().equals(null))) {
			
			return "failure";
		} else {
			
			return "failure";
		}

		
		
	}



	@Override
	public NewRegistrationOutputDto register(String firstname, String lastname, String middlename, String email, String phone,String identity) {
		
		NewRegistration newUser= this.convertToNewRegistrationInputDto(firstname,lastname,middlename,email,phone,identity);
		NewRegistration registered=this.registerservice.save(newUser);
		NewRegistrationOutputDto registerOutputDto = this.convertToNewRegistrationOutputDto(registered);
		
		return registerOutputDto;
	}



	@Override
	@Transactional
	public BankAccountOutputDto createNewAccount(String account, String amount, int cusid) {
		// TODO Auto-generated method stub
		
		BankAccount newAccount = this.convertToBankAccountInputDto(account,amount,cusid);
		BankAccount accountOutputDto= this.bankaccountservice.save(newAccount);

		BankAccountOutputDto bankAccountOutputDto =this.convertEntityToOutputBankAccountDto(accountOutputDto);
		Long accountnumber=accountOutputDto.getId();
		BankTransaction trans= this.convertToBankTransactionsInputDto(accountnumber, "Initial", Double.parseDouble(amount)); 
		this.repository.save(trans);
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

	@Override
	@Transactional
	public CardDetailsOutputDto getCardDetails(Long Cusid) {
		
		
		//List<CardDetailsOutputDto> cardDetailsOutputDtos = new ArrayList<CardDetailsOutputDto>();
		CardDetails card = this.cardsservice.getAll(Cusid);
		CardDetailsOutputDto cardDetailsOutputDto = this.convertToCardDetailsOutputDto(card);

		return cardDetailsOutputDto;
	}



	private CardDetailsOutputDto convertToCardDetailsOutputDto(CardDetails card) {
		// TODO Auto-generated method stub
		CardDetailsOutputDto details =new CardDetailsOutputDto();
		//details.setCusid(card.getCusid());
		details.setCardnumber(card.getCardnumber());
		details.setBalance(card.getBalance());
		details.setExpirydate(card.getExpirydate());
		details.setStatus(card.getStatus());
		
		return details;
	}
	


}
