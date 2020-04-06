package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.RoleEntity;

public interface RoleRepositoryCustom {
	RoleEntity findRoleOfUser(long userId);
}
