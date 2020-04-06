package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.api.input.ProductInput;
import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	Long save(ProductDTO productDto);
	ProductDTO showProduct(long id);
	ProductDTO newsProduct(long id,ProductInput product);
	void drop(long[] ids);
}
