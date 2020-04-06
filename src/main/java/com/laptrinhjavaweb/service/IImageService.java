package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ImageDTO;

public interface IImageService {
	Long save(long productId,ImageDTO imageDto);
	void drop(long [] ids);
}
