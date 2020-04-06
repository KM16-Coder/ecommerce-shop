package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
