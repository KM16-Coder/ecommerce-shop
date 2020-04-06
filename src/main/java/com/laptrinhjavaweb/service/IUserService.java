package com.laptrinhjavaweb.service;

import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.api.input.UserInput;
import com.laptrinhjavaweb.api.output.JwtResponse;
import com.laptrinhjavaweb.api.output.UserOutput;
import com.laptrinhjavaweb.dto.UserDTO;
@Service
public interface IUserService {
	Long save(UserDTO userDto);
	UserOutput showUser(long id);
	UserOutput newsUser(long id,UserInput userInput);
	void drop(long[] ids);
	JwtResponse findUser(String userName,String passWord);
	
}
