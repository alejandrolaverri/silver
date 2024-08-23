package com.alejandromo.web.controller;

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

import com.alejandromo.domain.dto.CategoryDto;
import com.alejandromo.domain.service.CategoryService;
import com.alejandromo.domain.service.ShoeService;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ShoeService shoeService;

	@GetMapping("/category")
	public ResponseEntity<List<CategoryDto>> getAllCategories(@RequestParam(required = false) String name) {
		List<CategoryDto> res = new ArrayList<>();
		if (name == null) {
			res = categoryService.getAll();
		} else {
			res = categoryService.getByName(name);
		}
		if (res == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id) {
		CategoryDto category = categoryService.getCategory(id);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PostMapping("/category")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto category) {
		return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
	}
	
	@PostMapping("/categories")
	public ResponseEntity<List<CategoryDto>> addCategories(@RequestBody List<CategoryDto> categories) {
		if (categories.size() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(categoryService.saveAll(categories), HttpStatus.CREATED);
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable int id, @RequestBody CategoryDto category) {
		CategoryDto temp = categoryService.getCategory(id);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (temp.getIdCategory() != category.getIdCategory()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} else {
			BeanUtils.copyProperties(category, temp);
			return new ResponseEntity<>(categoryService.save(temp), HttpStatus.OK);
		}
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id) {
		CategoryDto category = categoryService.getCategory(id);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (shoeService.existsShoesInCategory(id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		categoryService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
