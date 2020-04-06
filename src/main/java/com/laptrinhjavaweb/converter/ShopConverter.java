package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ShopDTO;
import com.laptrinhjavaweb.entity.ShopEntity;

@Component
public class ShopConverter {
	@Autowired
	private ModelMapper modelMapper;
	public ShopDTO convertEntityToDto(ShopEntity shopEntity) {
		return modelMapper.map(shopEntity,ShopDTO.class);
	}
	public ShopEntity convertDtoToEntity(ShopDTO shopDto) {
		return modelMapper.map(shopDto,ShopEntity.class);
	}
}
