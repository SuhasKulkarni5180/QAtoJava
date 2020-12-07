package com.iiht.training.eloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.ProcessingInfo;

@Repository
public interface ProcessingInfoRepository extends JpaRepository<ProcessingInfo, Long>{
	
	
//	@Query("FROM ProcessingInfo WHERE loanAppId = ?1")
//	ProcessingInfo findByLoanId(Long loanAppId);

}
