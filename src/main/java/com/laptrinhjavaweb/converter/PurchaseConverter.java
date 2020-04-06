package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.PurchaseDTO;
import com.laptrinhjavaweb.entity.PurchaseEntity;

@Component
public class PurchaseConverter {
	@Autowired
	private ModelMapper modelMapper;
	public PurchaseDTO convertEntityToDto(PurchaseEntity imageEntity) {
		return modelMapper.map(imageEntity,PurchaseDTO.class);
	}
	public PurchaseEntity convertDtoToEntity(PurchaseDTO imageDto) {
		return modelMapper.map(imageDto	,PurchaseEntity.class);
	}
}
