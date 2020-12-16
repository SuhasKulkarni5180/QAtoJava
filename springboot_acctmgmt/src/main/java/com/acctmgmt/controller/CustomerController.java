package com.acctmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acctmgmt.dto.BankAccountOutputDto;
import com.acctmgmt.dto.BankTransactionInputDto;
import com.acctmgmt.dto.BankTransactionsOutputDto;

import com.acctmgmt.dto.UsersOutputDto;
import com.acctmgmt.repository.BankTransactionRepository;
import com.acctmgmt.service.Customer;


@Controller
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private Customer service;
	
	@GetMapping("/balanceaccountinput")
	public String getacctnumber() {
		
		
		return "balance-check";
		
	}
	
	@GetMapping("/balance")
	public String getBalance(@RequestParam("accountnumber") String accountnumber,Model model){
	
			BankAccountOutputDto customerOutputDto=this.service.getBalance(Integer.parseInt(accountnumber));
			model.addAttribute("customeroutput", customerOutputDto);
		return "balance-check";
	}
	
	@GetMapping("/mini")
	public String getmini() {
		
		return "select-account";
	
	}
	
	
	@GetMapping("/ministatement")
	public String getminiStatement(@RequestParam("accountnumber") String accountNumber,Model model){
		List<BankTransactionsOutputDto> bankTransactionOutputDto=this.service.getminiStatement(Long.parseLong(accountNumber));
		model.addAttribute("mini",bankTransactionOutputDto);
		return "mini-statement";
	}
	
	@GetMapping("/showMenu")
	public String showMenu() {

		return "menu";
	}
	
	@GetMapping("/login")
	public String loginInit() {

		return "Login";
	}
	

	@PostMapping("/user")
	public String login(@RequestParam("userName") String usrName, @RequestParam("pwd") String pwd) {
		
		String response = service.login(usrName, pwd);

		if(response.equals("success")) {
		
			return "menu";
		}
		else {
			return "login-failure";
		}
		
	}

	
	@GetMapping("/selectMonth")
	public String redirectMonth() {

		return "select-month";
	}
	
	@GetMapping("/monthly")
	public String getmonthlyStatement(@RequestParam("accountnumber")String acctNumber,@RequestParam("month") String month,Model model){
			List<BankTransactionsOutputDto> customerOutputDto = this.service.getmonthlyStatement(Long.parseLong(acctNumber),Integer.parseInt(month));
			
			model.addAttribute("customeroutput",customerOutputDto);
			return "monthlystatement";
		}
	
	@GetMapping("/selectYear")
	public String redirectYear() {

		return "select-year";
	}
	
		
	@GetMapping("/yearly")
	public String getyearlyStatement(@RequestParam("year") String year,Model model){
		
		Integer Cusid =1;
		List<BankTransactionsOutputDto> customerOutputDto = this.service.getyearlyStatement(Cusid, Integer.parseInt(year));
		model.addAttribute("yearly",customerOutputDto);
		

		return "yearly-statement";

	}
	
	
	@GetMapping("/createTrans")
	public String createTrans() {
		
		// save the customer using our service

		return "trans-form";
	}
	
	@GetMapping("/transaction")
	public String newTransaction(@RequestParam("accountnumber") String acctnumber,@RequestParam("transType") String transType,@RequestParam("amount")String amount,Model model) {
		
		BankTransactionsOutputDto bankTransOutputDto =this.service.createTrans(Long.parseLong(acctnumber),transType,Double.parseDouble(amount));
		model.addAttribute("trans",bankTransOutputDto);
		return "trans-success";
	}
	
	
	@GetMapping("/register")
	public String registration() {

		return "newregistration";
	}
	
	@GetMapping("/registrationform")
	public String register(@RequestParam ("firstName") String firstname,@RequestParam("lastName") String lastname,@RequestParam("middleName") String middlename,
							@RequestParam("email") String email,@RequestParam("phone") String phone, Model model) {
		
		// save the customer using our service
		UsersOutputDto userOutputDto = this.service.register(firstname,lastname,middlename,email,phone);
		model.addAttribute("register",userOutputDto);
		return "register-success";
	}
	
	
	
	@GetMapping("/createAccount")
	public String createAccount() {
		
		return "create-account";
		
		
	}
	
	@GetMapping("/newAccount")
	public String newAccount(@RequestParam("accountType") String account,@RequestParam("amount") String amount,@RequestParam("cusid") String cusid, Model model) {
		
		BankAccountOutputDto bankAccountOutputDto = this.service.createNewAccount(account,amount,Integer.parseInt(cusid));
		model.addAttribute("newaccount",bankAccountOutputDto);
		
		return "newaccountcreated";
		
		
	}
	
		

}
