package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.input.UserInput;
import com.laptrinhjavaweb.api.output.UserOutput;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
@RestController
@RequestMapping("/admin")
@Transactional
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	
	@PostMapping(value="/accounts")
	public Long saveUser(@RequestBody UserDTO userDto) {
		return userService.save(userDto);
	
	}
	@GetMapping(value="/{userid}")
	public UserOutput getUser(@PathVariable ("userid") long userId) {
		return userService.showUser(userId);
		
	}
	
	@PutMapping(value="/user")
	public UserOutput updateUser(@RequestParam long userid, @RequestBody UserInput userInput) {
		
		return userService.newsUser(userid, userInput);
	}
	
	@DeleteMapping(value="/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.drop(ids);
		
	}
	
}
