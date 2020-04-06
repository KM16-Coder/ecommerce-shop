package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.StoreDTO;
import com.laptrinhjavaweb.service.IStoreService;

@RestController
@RequestMapping("/admin")
@Transactional
public class StoreAPI {
	@Autowired
	private IStoreService storeService;

	@PostMapping(value = "/store")
	public Long saveStore(@RequestBody StoreDTO storeDto) {
		return storeService.save(storeDto);
	}

	@DeleteMapping(value = "/store")
	public void dropStore(@RequestBody long[] ids) {
		storeService.drop(ids);
	}
}
