package com.iiht.training.eloan.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	@Modifying
	@Query("UPDATE Loan l SET l.status =:status WHERE l.id =:loanid")
	void upDateStatus(@Param("status")Long status,@Param("loanid") Long loanAppId);

	
	@Query("FROM Loan l WHERE l.status=:status")
	Loan getStatus(@Param("status")Long loanAppId);
	
	@Query("FROM Loan l WHERE l.status=:status")
	List<Loan> findAllBYApplied(@Param("status")Long id);
	
	@Query("FROM Loan l WHERE l.status=:status")
	List<Loan> findAllProcessedLoan(@Param("status")Long id);

	@Modifying
	@Query("UPDATE Loan l SET l.status =:status,l.remark =: WHERE l.id =:loanid")
	void upDateStatusReject(@Param("status")long l,@Param("remark")Loan reject,@Param("loanid")Long loanAppId);
	

}
