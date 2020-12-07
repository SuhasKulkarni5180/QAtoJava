package com.iiht.training.eloan.service.impl;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	


	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	//Utility methods
	
	private Users converttoInputUserDto(UserDto userDto) {
		
		Users user = new Users();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setMobile(userDto.getMobile());
		user.setRole("Customer");
		return user;
		
	}
	
	private UserDto converttoOutputDto(Users newuser) {
		
		UserDto userDto = new UserDto();
		userDto.setFirstName(newuser.getFirstName());
		userDto.setLastName(newuser.getLastName());
		userDto.setEmail(newuser.getEmail());
		userDto.setMobile(newuser.getMobile());
		userDto.setId(newuser.getId());

		return userDto;
		
	}
	
	private Loan converttoInputLoanDto(Long customerId, LoanDto loanDto) {
		Loan loan = new Loan();
		Date date = new Date();
		String d = date.toString();
		loan.setLoanApplicationDate(d);
		loan.setLoanName(loanDto.getLoanName());
		loan.setBillingIndicator(loanDto.getBillingIndicator());
		loan.setBusinessStructure(loanDto.getBusinessStructure());
		loan.setLoanAmount(loanDto.getLoanAmount());
		loan.setTaxIndicator(loanDto.getTaxIndicator());
		loan.setCustomerId(customerId);
		loan.setRemark("New application");
		Long status = (long) 0;
		loan.setStatus(status);

		return loan;
		
	}
	
	
	private LoanOutputDto convertToLoanOutputDto(Loan newLoan) {
		LoanOutputDto loanOutputDto = new LoanOutputDto();
		loanOutputDto.setCustomerId(newLoan.getCustomerId());
		if(newLoan.getStatus()==0) {
			loanOutputDto.setStatus("Applied");
		}
		loanOutputDto.setRemark(newLoan.getRemark());
		return loanOutputDto;
		
	}
	
	private LoanOutputDto converttoOutputStatusDto(Loan status) {
		LoanOutputDto loanOutputDto = new LoanOutputDto();
		if(status.getStatus()==0){
			loanOutputDto.setStatus("Applied");
	
		}else if(status.getStatus()==1) {
			loanOutputDto.setStatus("Processed");
			
		}else if(status.getStatus()==2) {
			loanOutputDto.setStatus("Approved");
			
		}else{
			loanOutputDto.setStatus("Rejected");
			
		}
	
		return loanOutputDto;
		
	}
	
	
	
	@Override
	public UserDto register(UserDto userDto) {
		// TODO Auto-generated method stub
		Users user= this.converttoInputUserDto(userDto);
		
		Users newuser=this.usersRepository.save(user);
		
		UserDto userDtos = this.converttoOutputDto(newuser);
		return userDtos;
	}

	@Override
	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) {
		// TODO Auto-generated method stub
		Loan loan = this.converttoInputLoanDto(customerId,loanDto);
		
		Loan newloan=this.loanRepository.save(loan);
		
		LoanOutputDto loanoutputDto=this.convertToLoanOutputDto(newloan);
		
		
		return loanoutputDto;
	}

	@Override
	@Transactional
	public LoanOutputDto getStatus(Long loanAppId) {
		// TODO Auto-generated method stub
		
		Loan status =this.loanRepository.getStatus(loanAppId);
		
		LoanOutputDto loanOutputDto = this.converttoOutputStatusDto(status);

		return loanOutputDto;
		
	}

	@Override
	public List<LoanOutputDto> getStatusAll(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
