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
import com.alejandromo.models.Color;
import com.alejandromo.models.Shoe;
import com.alejandromo.repositories.CategoryRepository;
import com.alejandromo.repositories.ColorRepository;
import com.alejandromo.repositories.ShoeRepository;

@RestController
@RequestMapping("/api")
public class ShoeController {

	@Autowired
	private ShoeRepository shoeRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ColorRepository colorRepository;

	@GetMapping("/shoe")
	public ResponseEntity<List<Shoe>> getAllShoes(@RequestParam(required = false) String name, 
			@RequestParam(required = false) String description) {
		List<Shoe> res = new ArrayList<>();
		if (name != null && description != null) {
			for (Shoe shoe : shoeRepository.findByNameContainingOrDescriptionContaining(name, description)) {
				res.add(shoe);
			}
		} else if (name != null && description == null) {
			for (Shoe shoe : shoeRepository.findByNameContaining(name)) {
				res.add(shoe);
			}
		} else if (name == null && description != null) {
			for (Shoe shoe : shoeRepository.findByDescriptionContaining(description)) {
				res.add(shoe);
			}
		} else {
			for (Shoe shoe : shoeRepository.findAll()) {
				res.add(shoe);
			}
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/shoe/{id}")
	public ResponseEntity<Shoe> getShoe(@PathVariable int id) {
		Shoe shoe = shoeRepository.findById(id).orElse(null);
		if (shoe == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(shoe, HttpStatus.OK);
	}

	@GetMapping("/category/{id}/shoe")
	public ResponseEntity<List<Shoe>> getAllByCategory(@PathVariable int id) {
		List<Shoe> res = new ArrayList<>();
		for (Shoe shoe : shoeRepository.findByCategoryIdCategory(id)) {
			res.add(shoe);
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/category/{id}/shoe")
	public ResponseEntity<Shoe> addShoe(@PathVariable("id") int id, @RequestBody Shoe shoe) {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Shoe temp = new Shoe(shoe.getName(), shoe.getDescription(), shoe.getPrice(), category);
		return new ResponseEntity<Shoe>(shoeRepository.save(temp), HttpStatus.CREATED);
	}

	@PostMapping("/shoe/{idshoe}/color/{idcolor}")
	public ResponseEntity<Shoe> addShoeColor(@PathVariable("idshoe") int idShoe, @PathVariable("idcolor") int idColor) {
		Shoe shoe = shoeRepository.findById(idShoe).orElse(null);
		Color color = colorRepository.findById(idColor).orElse(null);

		if (shoe == null || color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		shoe.getColors().add(color);
		return new ResponseEntity<>(shoeRepository.save(shoe), HttpStatus.CREATED);
	}

	@PutMapping("/shoe/{id}")
	public ResponseEntity<Shoe> updateShoe(@PathVariable("id") int id, @RequestBody Shoe shoe) {
		Shoe temp = shoeRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (temp.getIdShoe() != shoe.getIdShoe()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} else {
			BeanUtils.copyProperties(shoe, temp);
			return new ResponseEntity<>(shoeRepository.save(temp), HttpStatus.OK);
		}
	}

	@DeleteMapping("/shoe/{id}")
	public ResponseEntity<HttpStatus> deleteShoe(@PathVariable("id") int id) {
		Shoe shoe = shoeRepository.findById(id).orElse(null);
		if (shoe == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		shoeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/shoe/{idshoe}/color/{idcolor}")
	public ResponseEntity<Shoe> deleteShoeColor(@PathVariable("idshoe") int idShoe,
			@PathVariable("idcolor") int idColor) {
		Shoe shoe = shoeRepository.findById(idShoe).orElse(null);
		Color color = colorRepository.findById(idColor).orElse(null);
		if (shoe == null || color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		shoe.getColors().remove(color);
		return new ResponseEntity<>(shoeRepository.save(shoe), HttpStatus.OK);
	}
}
