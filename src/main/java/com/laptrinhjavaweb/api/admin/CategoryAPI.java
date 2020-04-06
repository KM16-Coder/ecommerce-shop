package com.laptrinhjavaweb.api.admin;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.ICategoryService;

@RestController
@RequestMapping("/admin")
@Transactional
public class CategoryAPI {
	@Autowired
	ICategoryService categoryService;
	@PostMapping(value="/category")
	Long saveCategory(@RequestBody CategoryDTO dto) {
		return categoryService.save(dto);
	}
	@PutMapping(value="/category")
	Long saveGenderToCategory(@RequestParam Map<String,String> model) {
		return categoryService.saveGenderToCategory(Long.parseLong(model.get("idgender")), Long.parseLong(model.get("idcategory")));
	}
}
