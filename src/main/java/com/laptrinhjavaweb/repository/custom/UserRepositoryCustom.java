package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.api.input.UserInput;
import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepositoryCustom {
	UserEntity findInforUser(long id);
}
