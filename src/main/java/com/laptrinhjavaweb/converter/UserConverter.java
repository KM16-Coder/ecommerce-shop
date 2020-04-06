package com.laptrinhjavaweb.converter;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConverter {
	@Autowired
	private ModelMapper modelMapper;
	public UserDTO convertEntityToDto(UserEntity userEntity) {
		UserDTO userDto=modelMapper.map(userEntity, UserDTO.class);
		return userDto;
	}
	public UserEntity convertDtoToEntity(UserDTO userDto) {
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		return userEntity;
		
	}
}
