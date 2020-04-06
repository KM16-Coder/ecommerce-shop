package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryGenderDTO;
import com.laptrinhjavaweb.entity.CategoryGenderEntity;

@Component
public class CategoryGenderConverter {
	@Autowired
	private ModelMapper modelMapper;
	public CategoryGenderDTO convertEntityToDto(CategoryGenderEntity categoryGenderEntity) {
		return modelMapper.map(categoryGenderEntity,CategoryGenderDTO.class);
	}
	public CategoryGenderEntity convertDtoToEntity(CategoryGenderDTO categoryGenderDto) {
		return modelMapper.map(categoryGenderDto,CategoryGenderEntity.class);
	}
}
