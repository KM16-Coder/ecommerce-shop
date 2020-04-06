package com.laptrinhjavaweb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.api.input.ProductInput;
import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.CategoryGenderEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.StoreEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.repository.StoreRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConverter productConverter;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private StoreRepository storeRepos;
	@Override
	public Long save(ProductDTO productDto) {
		CategoryEntity categoryEntity=categoryRepository.findOneByCode(productDto.getCategory());
		ProductEntity productEntity=productConverter.convertDtoToEntity(productDto);
		categoryEntity.getProducts().add(productEntity);
		productEntity.setCategory(categoryEntity);
		productEntity.setStatus(1);
		StoreEntity storeEntity=storeRepos.findOneByCode(productDto.getStore());
		storeEntity.getProductStores().add(productEntity);
		productEntity.setStoreEntity(storeEntity);
		productEntity=productRepository.save(productEntity);
		return productEntity.getId();
		
	}
	@Override
	public ProductDTO showProduct(long id) {
		ProductEntity productEntity=productRepository.getOne(id);
		CategoryEntity categoryEntity=productEntity.getCategory();
		CategoryGenderEntity categoryGenderEntity=categoryEntity.getCategoryGender();
		ProductDTO productDto=productConverter.convertEntityToDto(productEntity);
		productDto.setCategory(categoryEntity.getName());
		productDto.setCategoryGender(categoryGenderEntity.getName());
		return productDto;
	}
	@Override
	public ProductDTO newsProduct(long id, ProductInput product) {
		CategoryEntity categoryEntity=null;
		CategoryGenderEntity categoryGenderEntity=null;
		ProductEntity newProductEntity=modelMapper.map(product, ProductEntity.class);
		newProductEntity.setCategory(categoryRepository.findOneByCode(product.getCategory()));
		categoryEntity=newProductEntity.getCategory();
		categoryGenderEntity=categoryEntity.getCategoryGender();
		ProductDTO productDto=productConverter.convertEntityToDto(newProductEntity);
		productDto.setCategory(categoryEntity.getName());
		productDto.setCategoryGender(categoryGenderEntity.getName());
		return productDto;
	}
	@Override
	public void drop(long[] ids) {
		for(long id :ids) {
			productRepository.deleteById(id);
		}
		
	}
}
