package com.acctmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acctmgmt.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount , Long>{

	@Query("FROM BankAccount b WHERE b.id=:acctNumber")
	BankAccount findByacctNumber(@Param("acctNumber")Long acctNumber);
	
	@Modifying
	@Query("UPDATE BankAccount b SET b.balance =:bal WHERE b.id = :acctNumber")
	void updateBalance(@Param("bal")Double acc,@Param("acctNumber")Long acctNumber);

	
	

	

}
