package com.acctmgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.acctmgmt.dto.BankTransactionsOutputDto;
import com.acctmgmt.dto.NewRegistrationOutputDto;
import com.acctmgmt.dto.UsersOutputDto;
import com.acctmgmt.entity.BankTransaction;
import com.acctmgmt.entity.NewRegistration;
import com.acctmgmt.entity.Users;
import com.acctmgmt.repository.BankAccountRepository;
import com.acctmgmt.repository.BankTransactionRepository;
import com.acctmgmt.repository.NewRegistrationRepository;
import com.acctmgmt.repository.UsersRepository;


@Component
public class ExecutiveImpl implements Executive{
	
	@Autowired
	private BankTransactionRepository repository;
	
	
	@Autowired
	private UsersRepository userservice;
	
	@Autowired
	private BankAccountRepository bankaccountservice;
	
	@Autowired
	private NewRegistrationRepository registerservice;
	
	
	private UsersOutputDto convertToUserOutputDto(Users exec) {
		
		UsersOutputDto executive = new UsersOutputDto();
		executive.setRole(exec.getRole());
		executive.setUsername(exec.getUserName());
		executive.setPassword(exec.getPassword());
		
		return executive;
		
	}
	
	private NewRegistrationOutputDto convertToNewRegistrationOutputDto(NewRegistration status) {
		
		NewRegistrationOutputDto app=new NewRegistrationOutputDto();
		app.setAppId(status.getId());
		app.setFirstname(status.getFirstName());
		app.setIdentity(status.getIdentity());
		app.setPhone(status.getMobile());
		app.setEmail(status.getEmail());
		Long st= status.getStatus();
		if(st==1) {
			app.setStatus("Not Approved");
		}
			
		return app;
		
	}

	@Override
	@Transactional
	public String login(String usrName, String pwd) {
		
			Users executive = userservice.findByUserName(usrName,pwd);
			UsersOutputDto oldexecutive =this.convertToUserOutputDto(executive);

			if((oldexecutive.getUsername()).equals(usrName)&&(oldexecutive.getPassword().equals(pwd))){	
				
				return "success";
			}else if((oldexecutive.getUsername()).equals(null)&&(oldexecutive.getPassword().equals(null))) {
				
				return "failure";
			} else {
				
				return "failure";
			}
	
	}

	@Override
	public NewRegistrationOutputDto getApplicationStatus(Long appID) {
		
		NewRegistration status= this.registerservice.findByAppID(appID);
		NewRegistrationOutputDto appstatus=this.convertToNewRegistrationOutputDto(status);
	
		return appstatus;
		
	}

	@Override
	public List<NewRegistrationOutputDto> getAllStatus() {
		Long status = (long) 1;
		List<NewRegistrationOutputDto> newUnapproved = new ArrayList<>();
		List<NewRegistration> allUnapproved = this.registerservice.findByStatus(status);
		
		for(NewRegistration allStatus : allUnapproved) {
			NewRegistrationOutputDto newRegistration = this.convertToNewRegistrationOutputDto(allStatus);
			newUnapproved.add(newRegistration);
		}
		
		return newUnapproved;
	}



}
