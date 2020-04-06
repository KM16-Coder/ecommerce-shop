package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryGenderConverter;
import com.laptrinhjavaweb.dto.CategoryGenderDTO;
import com.laptrinhjavaweb.repository.CategoryGenderRepository;
import com.laptrinhjavaweb.service.ICategoryGenderService;
@Service
public class CategoryGenderService implements ICategoryGenderService{

	@Autowired
	CategoryGenderConverter converter;
	@Autowired
	CategoryGenderRepository repository;
	@Override
	public Long save(CategoryGenderDTO dto) {
		return repository.save(converter.convertDtoToEntity(dto)).getId();
	}

	

}
