package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ClerkService;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	private LoanOutputDto convertToLoanOutputDto(Loan all) {
		
		LoanOutputDto loanOutputDto = new LoanOutputDto();
		ProcessingDto process = new ProcessingDto();
		loanOutputDto.setCustomerId(all.getCustomerId());
		loanOutputDto.setRemark(all.getRemark());
		if(all.getStatus()==0){
			loanOutputDto.setStatus("Applied");		
		}
		
		return loanOutputDto;
	
	}
	
	private ProcessingInfo convertToInputProcessDto(Long clerkId, Long loanAppId, ProcessingDto processingDto){
		
		ProcessingInfo process = new ProcessingInfo();
		process.setLoanAppId(loanAppId);
		process.setLoanClerkId(clerkId);
		process.setAcresOfLand(processingDto.getAcresOfLand());
		process.setAddressOfProperty(processingDto.getAddressOfProperty());
		process.setAppraisedBy(processingDto.getAppraisedBy());
		process.setLandValue(processingDto.getLandValue());
		process.setSuggestedAmountOfLoan(processingDto.getSuggestedAmountOfLoan());
		process.setValuationDate(processingDto.getValuationDate());
		
		return process;
		
	}
	private ProcessingDto convertToOutputProcessDto(ProcessingInfo newprocess) {
		ProcessingDto processDto = new ProcessingDto();
		
		processDto.setAcresOfLand(newprocess.getAcresOfLand());
		processDto.setAddressOfProperty(newprocess.getAddressOfProperty());
		processDto.setAppraisedBy(newprocess.getAppraisedBy());
		processDto.setLandValue(newprocess.getLandValue());
		processDto.setSuggestedAmountOfLoan(newprocess.getSuggestedAmountOfLoan());
		processDto.setValuationDate(newprocess.getValuationDate());
		return processDto;
		
	}
	
	@Override
	public List<LoanOutputDto> allAppliedLoans() {
		
		Long i = (long) 0;
		List<Loan> allappliedloans =this.loanRepository.findAllBYApplied(i);
		List<LoanOutputDto> loanOutputDtos = new ArrayList<LoanOutputDto>();
		for(Loan all : allappliedloans) {
			LoanOutputDto loanOutputDto = this.convertToLoanOutputDto(all);
			loanOutputDtos.add(loanOutputDto);
		}
	
		return loanOutputDtos;
	}

	@Override
	@Transactional
	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) {
		// TODO Auto-generated method stub
		ProcessingInfo process = this.convertToInputProcessDto(clerkId,loanAppId,processingDto);
		
		ProcessingInfo newProcess=this.pProcessingInfoRepository.save(process);
		
		ProcessingDto processDto= this.convertToOutputProcessDto(newProcess);
		
		this.loanRepository.upDateStatus((long) 1, loanAppId);
		
		
		return processDto;
	}

}
