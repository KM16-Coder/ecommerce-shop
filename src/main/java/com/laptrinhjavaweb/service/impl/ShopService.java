package com.laptrinhjavaweb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ShopConverter;
import com.laptrinhjavaweb.dto.ShopDTO;
import com.laptrinhjavaweb.entity.ShopEntity;
import com.laptrinhjavaweb.entity.StoreEntity;
import com.laptrinhjavaweb.repository.ShopRepository;
import com.laptrinhjavaweb.repository.StoreRepository;
import com.laptrinhjavaweb.service.IShopService;
@Service
public class ShopService implements IShopService{
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private ShopConverter shopConvert;
	@Autowired
	private StoreRepository storeRepos;
	@Override
	public Long save(String codeStore,ShopDTO shopDto) {
		StoreEntity storeEntity=storeRepos.findOneByCode(codeStore);
		ShopEntity shopEntity=shopConvert.convertDtoToEntity(shopDto);
		shopEntity.setStoreEntity(storeEntity);
		storeEntity.setShopEntity(shopEntity);
		shopEntity.setStatus(1);
		return shopRepository.save(shopEntity).getId();
	}
	@Override
	public ShopDTO showShop(long id) {
		return shopConvert.convertEntityToDto(shopRepository.getOne(id));
	}
	@Override
	public ShopDTO newsShop(long id, ShopDTO shopDto) {
		return shopConvert.convertEntityToDto(shopRepository.save(shopConvert.convertDtoToEntity(shopDto)));
		
	}
	@Override
	public void drop(long[] ids) {
		for(long id:ids) {
			shopRepository.deleteById(id);
		}
		
	}

}
