package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.IRoleService;

@RestController
@RequestMapping("/admin")
@Transactional
public class RoleAPI {
	@Autowired
	private IRoleService roleService;
	
	
	@PostMapping(value="/role")
	public Long saveUser(@RequestBody RoleDTO roleDto) {
		return roleService.save(roleDto);
	
	}
	
}
