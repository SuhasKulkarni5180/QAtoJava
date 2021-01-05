package com.acctmgmt.service;

import java.util.List;

import com.acctmgmt.dto.NewRegistrationOutputDto;

public interface Executive {

	public String login(String usrName, String pwd);

	public NewRegistrationOutputDto getApplicationStatus(Long appID);

	public List<NewRegistrationOutputDto> getAllStatus();

}
