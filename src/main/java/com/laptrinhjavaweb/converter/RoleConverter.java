package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;

@Component
public class RoleConverter {
	@Autowired
	ModelMapper modelMapper;
	public RoleDTO convertEntityToDto(RoleEntity roleEntity) {
		return modelMapper.map(roleEntity, RoleDTO.class);
	}
	public RoleEntity convertDtoToEntity(RoleDTO roleDto) {
		return modelMapper.map(roleDto, RoleEntity.class);
	}
}
