package com.alejandromo.web.controller;

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
import com.alejandromo.domain.dto.ShoeDto;
import com.alejandromo.domain.service.CategoryService;
import com.alejandromo.domain.service.ShoeService;

@RestController
@RequestMapping("/api")
public class ShoeController {

	@Autowired
	private ShoeService shoeService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/shoe")
	public ResponseEntity<List<ShoeDto>> getAllShoes(@RequestParam(required = false) String name, 
			@RequestParam(required = false) String description) {
		List<ShoeDto> shoes = shoeService.getByNameOrDescription(name, description);
		
		if (shoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(shoes, HttpStatus.OK);
	}

	@GetMapping("/shoe/{id}")
	public ResponseEntity<ShoeDto> getShoe(@PathVariable int id) {
		ShoeDto shoe = shoeService.get(id);
		if (shoe == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(shoe, HttpStatus.OK);
	}

	@GetMapping("/category/{id}/shoe")
	public ResponseEntity<List<ShoeDto>> getAllByCategory(@PathVariable int id) {
		List<ShoeDto> shoes = shoeService.getByCategory(id);
		if (shoes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(shoes, HttpStatus.OK);
	}

	@PostMapping("/category/{idcategory}/shoe")
	public ResponseEntity<ShoeDto> addShoe(@PathVariable("idcategory") int idCategory, 
									    @RequestBody ShoeDto shoe) {
		CategoryDto category = categoryService.getCategory(idCategory);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		shoe.setCategory(category);
		ShoeDto newShoe = shoeService.save(shoe);
		
		return new ResponseEntity<ShoeDto>(newShoe, HttpStatus.CREATED);
	}

	@PutMapping("/shoe/{id}")
	public ResponseEntity<ShoeDto> updateShoe(@PathVariable int id, @RequestBody ShoeDto shoe) {
		ShoeDto temp = shoeService.get(id);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (temp.getIdShoe() != shoe.getIdShoe()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} else {
			BeanUtils.copyProperties(shoe, temp);
			return new ResponseEntity<>(shoeService.save(shoe), HttpStatus.OK);
		}
	}

	@DeleteMapping("/shoe/{id}")
	public ResponseEntity<HttpStatus> deleteShoe(@PathVariable int id) {
		ShoeDto shoe = shoeService.get(id);
		if (shoe == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(shoeService.delete(id) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
}