package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Component
public class ProductConverter {
	@Autowired
	private ModelMapper modelMapper;
	public ProductDTO convertEntityToDto(ProductEntity productEntity) {
		return modelMapper.map(productEntity,ProductDTO.class);
	}
	public ProductEntity convertDtoToEntity(ProductDTO productDto) {
		return modelMapper.map(productDto,ProductEntity.class);
	}
}
