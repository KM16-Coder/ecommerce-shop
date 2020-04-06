package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.StoreDTO;
import com.laptrinhjavaweb.entity.StoreEntity;

@Component
public class StoreConverter {
	@Autowired
	private ModelMapper modelMapper;
	public StoreDTO convertEntityToDto(StoreEntity storeEntity) {
		return modelMapper.map(storeEntity,StoreDTO.class);
	}
	public StoreEntity convertDtoToEntity(StoreDTO storeDto) {
		return modelMapper.map(storeDto,StoreEntity.class);
	}
}
