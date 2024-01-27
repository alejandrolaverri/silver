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
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.models.Color;
import com.alejandromo.repositories.ColorRepository;

@RestController
@RequestMapping(path="/api")
public class ColorController {
	@Autowired
	ColorRepository colorRepository;
	
	@GetMapping("/color")
	public ResponseEntity<List<Color>> getAllColors() {
		List<Color> res = new ArrayList<>();
		for (Color color : colorRepository.findAll()) {
			res.add(color);
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/color/{id}")
	public ResponseEntity<Color> getColor(@PathVariable("id") int id) {
		Color color = colorRepository.findById(id).orElse(null);
		if (color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(color, HttpStatus.OK);		
	}
	
	@PostMapping("/color")
	public ResponseEntity<Color> addColor(@RequestBody Color color) {
		Color temp = colorRepository.save(new Color(color.getName()));
		return new ResponseEntity<>(temp, HttpStatus.CREATED);
	}
	
	@PostMapping("/colors")
	public ResponseEntity<List<Color>> addColors(@RequestBody List<Color> colors) {
		if (colors.size() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(colorRepository.saveAll(colors), HttpStatus.CREATED);
	}
	
	@PutMapping("/color/{id}")
	public ResponseEntity<Color> updateColor(@PathVariable("id") int id, @RequestBody Color color) {
		Color temp = colorRepository.findById(id).orElse(null);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		BeanUtils.copyProperties(color, temp);
		return new ResponseEntity<>(colorRepository.save(temp), HttpStatus.OK);
	}
	
	@DeleteMapping("/color/{id}")
	public ResponseEntity<HttpStatus> deleteColor(@PathVariable("id") int id) {
		Color color = colorRepository.findById(id).orElse(null);
		if (color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		colorRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
