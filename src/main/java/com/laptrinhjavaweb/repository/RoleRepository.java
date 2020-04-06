package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.custom.RoleRepositoryCustom;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>,RoleRepositoryCustom{

}
