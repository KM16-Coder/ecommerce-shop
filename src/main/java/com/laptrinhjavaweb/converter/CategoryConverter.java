package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {
	@Autowired
	private ModelMapper modelMapper;
	public CategoryDTO convertEntityToDto(CategoryEntity categoryEntity) {
		return modelMapper.map(categoryEntity,CategoryDTO.class);
	}
	public CategoryEntity convertDtoToEntity(CategoryDTO categoryDto) {
		return modelMapper.map(categoryDto,CategoryEntity.class);
	}
}
