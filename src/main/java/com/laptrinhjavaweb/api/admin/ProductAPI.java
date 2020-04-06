package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

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

import com.laptrinhjavaweb.api.input.ProductInput;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@RestController
@RequestMapping("/admin")
@Transactional
public class ProductAPI {
	@Autowired
	private IProductService productService;
	@PostMapping(value="/product")
	public Long saveProduct(@RequestBody ProductDTO productDto) {
		return productService.save(productDto);
		
	}
	
	@GetMapping(value="/product/{productid}")
	public ProductDTO showProduct(@PathVariable ("productid") long productId) {
		return productService.showProduct(productId);
		
	}
	@PutMapping(value="/product")
	public ProductDTO newsProduct(@RequestParam long productid,@RequestBody ProductInput product) {
		return productService.newsProduct(productid, product);
		
	}
	
	@DeleteMapping(value="/product")
	public void deleteProduct(@RequestBody long [] ids) {
		
		productService.drop(ids);
	}
}
