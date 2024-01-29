package com.alejandromo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.models.Category;
import com.alejandromo.repositories.CategoryRepository;
import com.alejandromo.repositories.ShoeRepository;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ShoeRepository shoeRepository;

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name) {
		List<Category> res = new ArrayList<>();
		if (name == null) {
			for (Category category : categoryRepository.findAll()) {
				res.add(category);
			}
		} else {
			for (Category category : categoryRepository.findByNameContaining(name)) {
				res.add(category);
			}
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category temp = categoryRepository.save(category);
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}
	
	@PostMapping("/categories")
	public ResponseEntity<List<Category>> addCategories(@RequestBody List<Category> categories) {
		if (categories.size() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(categoryRepository.saveAll(categories), HttpStatus.CREATED);
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
		Category temp = categoryRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (temp.getIdCategory() != category.getIdCategory()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} else {
			BeanUtils.copyProperties(category, temp);
			return new ResponseEntity<>(categoryRepository.save(temp), HttpStatus.OK);
		}
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (shoeRepository.existsByCategoryIdCategory(id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		categoryRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
