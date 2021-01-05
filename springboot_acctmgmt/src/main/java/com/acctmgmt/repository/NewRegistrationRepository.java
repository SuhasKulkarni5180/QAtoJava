package com.acctmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acctmgmt.dto.NewRegistrationOutputDto;
import com.acctmgmt.entity.NewRegistration;


@Repository
public interface NewRegistrationRepository extends JpaRepository<NewRegistration , Long>{

	@Query("FROM NewRegistration n WHERE n.id =:appID")	
	NewRegistration findByAppID(Long appID);
	
	
	@Query("FROM NewRegistration n WHERE n.status =:status")	
	List<NewRegistration> findByStatus(Long status);

}
