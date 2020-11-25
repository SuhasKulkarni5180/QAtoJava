package com.ibs.acctmgmt.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibs.acctmgmt.dao.CustomerDAO;
import com.ibs.acctmgmt.entity.BankAccount;
import com.ibs.acctmgmt.entity.BankTransaction;
import com.ibs.acctmgmt.entity.Customer;
import com.ibs.acctmgmt.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class AccountController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd() {

		return "create-account";
	}
	
	
	@GetMapping("/showMenu")
	public String showMenu() {

		return "menu";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@ModelAttribute("account") BankAccount bankAccount) {
		
		// save the customer using our service
		
		customerService.createAccount(bankAccount);

		return "account-success";
	}
	
	@GetMapping("/checkBalance")
	public String getAccountBalance(Model theModel) {

		// get customers from the service
		List<BankAccount> balances = customerService.getAccountBalances();
		theModel.addAttribute("balance", balances);
		
		return "balance-check";
	}
	
	@GetMapping("/createTrasaction")
	public String redirectTrans() {

		return "trans-form";
	}
	
	@PostMapping("/createTrans")
	public String createTrans(@ModelAttribute("transaction") BankTransaction bankTransaction) {
		
		// save the customer using our service
		customerService.createTrans(bankTransaction);

		return "trans-success";
	}
	
	@GetMapping("/miniStatement")
	public String getMiniStatement(Model theModel) {

		// get customers from the service
		List<BankTransaction> miniStatement = customerService.getMiniStatement(100);
		theModel.addAttribute("miniStatement", miniStatement);
		
		return "mini-statement";
	}
	
	@GetMapping("/selectMonth")
	public String redirectMonth() {

		return "select-month";
	}
	
	@GetMapping("/selectYear")
	public String redirectYear() {

		return "select-year";
	}
	
	@GetMapping("/monthlyStatement")
	public String monthlyStatement(@RequestParam("month") String month, Model theModel){

		List<BankTransaction> monthlyStatement = customerService.getMonthlyStatement(100, Integer.parseInt(month));
		theModel.addAttribute("monthlyStatement", monthlyStatement);
		return "monthly-statement";
	}
	
	@GetMapping("/yearlyStatement")
	public String yearlyStatement(@RequestParam("year") String year, Model theModel){

		List<BankTransaction> yearlyStatement = customerService.getYearlyStatement(100, Integer.parseInt(year));
		theModel.addAttribute("yearlyStatement", yearlyStatement);
		return "yearly-statement";
	}
	
	@PostMapping("/user")
	public String login(@RequestParam("userName") String usrName, @RequestParam("pwd") String pwd) {
		
		String response = customerService.login(usrName, pwd);

		if(response.equals("success")) {
		
			return "menu";
		}
		else {
			return "login-failure";
		}
		
	}
	
	@GetMapping("/login")
	public String loginInit() {

		return "Login";
	}
	
	@GetMapping("/payBills")
	public String payBills() {

		return "pay-bill";
	}
	
	
	
}


