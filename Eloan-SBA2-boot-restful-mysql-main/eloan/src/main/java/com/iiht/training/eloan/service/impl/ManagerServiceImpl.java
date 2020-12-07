package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

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
		loanOutputDto.setCustomerId(all.getCustomerId());
		loanOutputDto.setRemark(all.getRemark());
		if(all.getStatus()==1){
			loanOutputDto.setStatus("Processed");		
		}
		
		return loanOutputDto;
	
	}
	
	private Loan convertToLoanInputDto( RejectDto rejectDto) {
		
		Loan reject = new Loan();
		reject.setRemark(rejectDto.getRemark());
	
		return reject;
		
	}
	
	private RejectDto convertToRejectOutputDto(Loan status) {
		RejectDto rejected = new RejectDto();
		rejected.setRemark(status.getRemark());	
		return rejected;
		
	}
	

	
	@Override
	public List<LoanOutputDto> allProcessedLoans() {
		// TODO Auto-generated method stub
		Long i= (long) 1;
		List<Loan> allprocessedloans =this.loanRepository.findAllProcessedLoan(i);
		List<LoanOutputDto> loanOutputDtos = new ArrayList<LoanOutputDto>();
		for(Loan all : allprocessedloans) {
			LoanOutputDto loanOutputDto = this.convertToLoanOutputDto(all);
			loanOutputDtos.add(loanOutputDto);
		}
	
		return loanOutputDtos;
	
	}

	@Override
	public RejectDto rejectLoan(Long managerId, Long loanAppId, RejectDto rejectDto) {
		
		Loan reject = this.convertToLoanInputDto(rejectDto);
		
		this.loanRepository.upDateStatusReject((long) -1,reject, loanAppId);
		Loan status =this.loanRepository.getStatus(loanAppId);
		RejectDto rejected = this.convertToRejectOutputDto(status);
		return rejected;
	}

	@Override
	public SanctionOutputDto sanctionLoan(Long managerId, Long loanAppId, SanctionDto sanctionDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
