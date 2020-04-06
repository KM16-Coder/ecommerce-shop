package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.RoleConverter;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.service.IRoleService;
@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleConverter roleConverter;
	@Override
	public Long save(RoleDTO roleDto) {
		RoleEntity roleEntity=roleConverter.convertDtoToEntity(roleDto);
		roleEntity=roleRepository.save(roleEntity);
		return roleEntity.getId();
	}

}
