package com.acctmgmt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.acctmgmt.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {

	
	
	@Query("FROM Users u WHERE u.userName=:username AND u.password=:pwd")
	Users findByUserName(@Param("username")String usrName,@Param("pwd")String pwd);

	
	

}
