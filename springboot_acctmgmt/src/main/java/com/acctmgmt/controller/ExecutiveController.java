package com.acctmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acctmgmt.dto.NewRegistrationOutputDto;
import com.acctmgmt.service.Customer;
import com.acctmgmt.service.Executive;

	
@Controller
@RequestMapping("/api")
public class ExecutiveController {
	
		@Autowired
		private Executive executiveservice;
	

		
		@GetMapping("/executivelogin")
		public String executiveLogin() {
			return "executive-login";
		}
		
	
	
	@PostMapping("/executive")
	public String login(@RequestParam("userName") String usrName, @RequestParam("pwd") String pwd) {
		
		String response = executiveservice.login(usrName, pwd);

		if(response.equals("success")) {
		
			return "executivemenu";
		}
		else {
			return "login-failure";
		}
		
	}
	
	@GetMapping("/showExecutiveMenu")
	public String menu() {
		return "executivemenu";
	}
	
	@GetMapping("/getAppStatus")
	public String getAppStatus() {
		return "get-status";
	}
	
	@GetMapping("/applicationstatus")
	public String applicationstatus(@RequestParam("appid")String appID,Model model) {
		
		NewRegistrationOutputDto statusOutput =this.executiveservice.getApplicationStatus(Long.parseLong(appID));
		model.addAttribute("status",statusOutput);
		return "get-status";
	}
	
	@GetMapping("/getUnapproved")
	public String getUnapprovedList(Model model) {
		
		List<NewRegistrationOutputDto> newregistration = this.executiveservice.getAllStatus();
		model.addAttribute("unapproved",newregistration);
		return "get-unapproved";
		
	}


}
