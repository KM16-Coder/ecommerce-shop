package com.laptrinhjavaweb.api.admin;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryGenderDTO;
import com.laptrinhjavaweb.service.ICategoryGenderService;

@RestController
@RequestMapping("/admin")
@Transactional
public class CategoryGenderAPI {
	@Autowired
	ICategoryGenderService categoryGenderService;
	@PostMapping(value="/categorygender")
	Long saveCategoryGender(@RequestBody CategoryGenderDTO dto) {
		
		return categoryGenderService.save(dto);
	}
}
