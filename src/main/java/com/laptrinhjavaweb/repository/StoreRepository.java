package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
	StoreEntity findOneByCode(String code);
}
