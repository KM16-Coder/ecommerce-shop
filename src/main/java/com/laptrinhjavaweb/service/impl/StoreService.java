package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.StoreConverter;
import com.laptrinhjavaweb.dto.StoreDTO;
import com.laptrinhjavaweb.repository.StoreRepository;
import com.laptrinhjavaweb.service.IStoreService;

@Service
public class StoreService implements IStoreService{
	@Autowired
	private StoreRepository storeRepos;
	@Autowired
	private StoreConverter storeConvert;
	@Override
	public Long save(StoreDTO storeDto) {
		return storeRepos.save(storeConvert.convertDtoToEntity(storeDto)).getId();
	}

	@Override
	public void drop(long[] ids) {
		for(long id:ids) {
			storeRepos.deleteById(id);
		}
		
	}
}
