package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.CategoryGenderEntity;
import com.laptrinhjavaweb.repository.CategoryGenderRepository;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategoryGenderRepository categoryGenderRepository;
	@Autowired
	CategoryConverter categoryConverter;
	@Override
	public Long save(CategoryDTO dto) {
		return categoryRepository.save(categoryConverter.convertDtoToEntity(dto)).getId();
	}
	@Override
	public Long saveGenderToCategory(long idGender,long idCategory) {
		CategoryEntity categoryEntity=categoryRepository.getOne(idCategory);
		CategoryGenderEntity categoryGenderEntity=categoryGenderRepository.getOne(idGender);
		categoryEntity.setCategoryGender(categoryGenderEntity);
		categoryGenderEntity.getCategorys().add(categoryEntity);
		
		return categoryRepository.save(categoryEntity).getId();
	}
	
}
