package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CategoryDTO;

public interface ICategoryService {
	Long save(CategoryDTO dto);
	Long saveGenderToCategory(long idGender,long idCategory);
	
}
