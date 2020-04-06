package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.input.UserInput;
import com.laptrinhjavaweb.api.output.UserOutput;
import com.laptrinhjavaweb.dto.ShopDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IShopService;
import com.laptrinhjavaweb.service.IUserService;

@RestController
@RequestMapping("/admin")
@Transactional
public class ShopAPI {
	@Autowired
	private IShopService shopService;
	
	
	@PostMapping(value="/shop")
	public Long saveUser(@RequestParam String codestore, @RequestBody ShopDTO shopDto) {
		return shopService.save(codestore, shopDto);
	
	}
	@GetMapping(value="/{shopid}")
	public ShopDTO getUser(@PathVariable ("shopid") long shopId) {
		return shopService.showShop(shopId);
		
	}
	
	@PutMapping(value="/shop")
	public ShopDTO updateUser(@RequestParam long shopid, @RequestBody ShopDTO shopDto) {
		
		return shopService.newsShop(shopid, shopDto);
	}
	
	@DeleteMapping(value="/shop")
	public void deleteUser(@RequestBody long[] ids) {
		shopService.drop(ids);
		
	}
}
