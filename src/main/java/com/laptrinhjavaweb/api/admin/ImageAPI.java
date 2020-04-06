package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ImageDTO;
import com.laptrinhjavaweb.service.IImageService;

@RestController
@RequestMapping("/admin")
@Transactional
public class ImageAPI {
	@Autowired
	private IImageService imageService;
	@PostMapping(value="/image")
	public Long saveImage(@RequestParam long productid,@RequestBody ImageDTO imageDto) {
		return imageService.save(productid,imageDto);
		
	}
	@DeleteMapping(value="/image")
	public void deleteImage(@RequestBody long [] ids) {
		imageService.drop(ids);
		
	}
}
