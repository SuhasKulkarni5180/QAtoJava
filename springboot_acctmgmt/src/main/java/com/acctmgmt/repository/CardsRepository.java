package com.acctmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acctmgmt.entity.CardDetails;

@Repository
public interface CardsRepository extends JpaRepository<CardDetails,Long> {

	@Query("FROM CardDetails c WHERE c.Cusid=:Cusid")
	CardDetails getAll(@Param("Cusid")Long Cusid);

	}