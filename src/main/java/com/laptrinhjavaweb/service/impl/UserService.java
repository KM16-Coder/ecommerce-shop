package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.api.input.UserInput;
import com.laptrinhjavaweb.api.output.JwtResponse;
import com.laptrinhjavaweb.api.output.UserOutput;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	private UserConverter userConverter;
	@Override
	public Long save(UserDTO userDto) {
		UserEntity userEntity=userConverter.convertDtoToEntity(userDto);
		userEntity.setPassWord(passwordEncoder.encode(userEntity.getPassWord()));
		userEntity.setStatus(1);
		RoleEntity roleEntity=roleRepository.getOne(2L);
		userEntity.getRoles().add(roleEntity);
		roleEntity.getUsers().add(userEntity);
		userEntity=userRepository.save(userEntity);
		return userConverter.convertEntityToDto(userEntity).getId();
	}
	@Override
	public UserOutput showUser(long id) {
		UserEntity userEntity=userRepository.getOne(id);
		
		return modelMapper.map(userConverter.convertEntityToDto(userEntity), UserOutput.class);
	}
	@Override
	public UserOutput newsUser(long id, UserInput userInput) {
		UserEntity oldEntity=userRepository.getOne(id);
		UserEntity userEntity=modelMapper.map(userInput, UserEntity.class);
		userEntity.setId(id);
		userEntity.setPassWord(oldEntity.getPassWord());
		userEntity.setStatus(oldEntity.getStatus());
		userEntity=userRepository.save(userEntity);
		return modelMapper.map(userEntity, UserOutput.class);
	}
	@Override
	public void drop(long[] ids) {
		for(long id:ids) {
			userRepository.deleteById(id);
		}
		
	}
	@Override
	public JwtResponse findUser(String userName, String passWord) {
//		List<UserEntity> users=userRepository.findByUserName(userName);
//		System.out.println(passwordEncoder.matches(rawPassword, encodedPassword));
//		return null;
		return null;
	}
	
	

}
