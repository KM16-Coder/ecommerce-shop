package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.StoreDTO;

public interface IStoreService {
	Long save(StoreDTO storeDto);
	void drop(long[] ids);
}
