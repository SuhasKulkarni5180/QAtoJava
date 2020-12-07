package com.iiht.training.eloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register-clerk")
	public ResponseEntity<UserDto> registerClerk(@RequestBody UserDto userDto){
		
		UserDto adminDtos=this.adminService.registerClerk(userDto);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "AdminController");
        
        return ResponseEntity.accepted().headers(headers).body(adminDtos);
		
	}
	
	@PostMapping("/register-manager")
	public ResponseEntity<UserDto> registerManager(@RequestBody UserDto userDto){
		
		UserDto adminDtos=this.adminService.registerManager(userDto);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "AdminController");
        
        return ResponseEntity.accepted().headers(headers).body(adminDtos);
	}
	
	@GetMapping("/all-clerks")
	public ResponseEntity<List<UserDto>> getAllClerks(){
		
		
		List<UserDto> adminDtos=this.adminService.getAllClerks();
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "AdminController");
        
        return ResponseEntity.accepted().headers(headers).body(adminDtos);
		
	
	}
	
	@GetMapping("/all-managers")
	
	public ResponseEntity<List<UserDto>> getAllManagers(){
		List<UserDto> adminDtos=this.adminService.getAllManagers();
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "AdminController");
        
        return ResponseEntity.accepted().headers(headers).body(adminDtos);
	}
	
	
}
