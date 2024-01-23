package com.alejandromo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.models.Category;
import com.alejandromo.repositories.CategoryRepository;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/category")
	public @ResponseBody Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getById(@PathVariable int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(category, HttpStatus.OK);
		}
	}
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category temp = categoryRepository.save(category);
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}

}
