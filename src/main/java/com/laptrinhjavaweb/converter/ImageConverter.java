package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ImageDTO;
import com.laptrinhjavaweb.entity.ImageEntity;

@Component
public class ImageConverter {
	@Autowired
	private ModelMapper modelMapper;
	public ImageDTO convertEntityToDto(ImageEntity imageEntity) {
		return modelMapper.map(imageEntity,ImageDTO.class);
	}
	public ImageEntity convertDtoToEntity(ImageDTO imageDto) {
		return modelMapper.map(imageDto,ImageEntity.class);
	}
}
