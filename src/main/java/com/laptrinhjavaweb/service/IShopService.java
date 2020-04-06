package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ShopDTO;

public interface IShopService {
	Long save(String codeStore,ShopDTO shopDto);
	ShopDTO showShop(long id);
	ShopDTO newsShop(long id,ShopDTO shoptDto);
	void drop(long[] ids);
}
