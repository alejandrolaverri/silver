package com.alejandromo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.models.Category;
import com.alejandromo.repositories.CategoryRepository;

@RestController
@RequestMapping(path="/api")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public @ResponseBody Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

}
