package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsersRepository usersRepository;
	
	private Users convertToInputUserDto(UserDto userDto) {
		
		Users clerk= new Users();
		clerk.setFirstName(userDto.getFirstName());
		clerk.setLastName(userDto.getLastName());
		clerk.setEmail(userDto.getEmail());
		clerk.setMobile(userDto.getMobile());
		clerk.setRole("Clerk");
		
		return clerk;
		
	}
	private Users convertToInputManagerUserDto(UserDto userDto) {
		
		Users manager= new Users();
		manager.setFirstName(userDto.getFirstName());
		manager.setLastName(userDto.getLastName());
		manager.setEmail(userDto.getEmail());
		manager.setMobile(userDto.getMobile());
		manager.setRole("Manager");
		
		return manager;
		
	}
	
	private UserDto convertToOutputUserDto(Users user) {
		
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setMobile(user.getMobile());
		userDto.setId(user.getId());
		return userDto;
	
	}
	
	@Override
	public UserDto registerClerk(UserDto userDto) {
		// TODO Auto-generated method stub
		Users clerk = this.convertToInputUserDto(userDto);
		Users newClerk = this.usersRepository.save(clerk);
		UserDto userDtos =this.convertToOutputUserDto(newClerk);
		return userDtos;
	}

	@Override
	public UserDto registerManager(UserDto userDto) {
		// TODO Auto-generated method stub
		Users manager = this.convertToInputManagerUserDto(userDto);
		Users newmanager = this.usersRepository.save(manager);
		UserDto userDtos =this.convertToOutputUserDto(newmanager);
		return userDtos;
	}

	@Override
	public List<UserDto> getAllClerks() {
		// TODO Auto-generated method stub
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		String role ="Clerk";
		List<Users> allclerk = this.usersRepository.findByRole(role);
		for(Users clerk:allclerk) {
			UserDto userDto =this.convertToOutputUserDto(clerk);
			userDtos.add(userDto);
		}
		return userDtos;
	}

	@Override
	public List<UserDto> getAllManagers() {
		// TODO Auto-generated method stub
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		String role ="Manager";
		List<Users> allclerk = this.usersRepository.findByRole(role);
		for(Users clerk:allclerk) {
			UserDto userDto =this.convertToOutputUserDto(clerk);
			userDtos.add(userDto);
		}
		return userDtos;
	}

}
