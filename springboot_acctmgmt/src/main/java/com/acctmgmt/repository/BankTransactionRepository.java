package com.acctmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acctmgmt.entity.BankTransaction;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction , Long>{
	

	
	@Query("FROM BankTransaction b WHERE b.accountNumber = :acctNumber")
	List<BankTransaction> findByAccountNumber(@Param("acctNumber")Long acc);

	

}
