package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ImageConverter;
import com.laptrinhjavaweb.dto.ImageDTO;
import com.laptrinhjavaweb.entity.ImageEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ImageRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IImageService;
@Service
public class ImageService implements IImageService{

	@Autowired
	ImageRepository imageRepos;
	@Autowired
	ProductRepository productRepos;
	@Autowired
	ImageConverter imageConvert;
	@Override
	public Long save(long productId,ImageDTO imageDto) {
		ProductEntity productEntity=productRepos.getOne(productId);
		ImageEntity imageEntity=imageConvert.convertDtoToEntity(imageDto);
		imageEntity.setProduct(productEntity);
		productEntity.getImages().add(imageEntity);
		
		return imageRepos.save(imageEntity).getId();
	}
	@Override
	public void drop(long[] ids) {
		for(long id:ids) {
			imageRepos.deleteById(id);
		}
		
	}

}
