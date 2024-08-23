package com.alejandromo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.domain.service.SizeService;
import com.alejandromo.domain.dto.SizeDto;
@RestController
@RequestMapping(path = "/api")
public class SizeController {
	@Autowired
	private SizeService sizeService;
	
	@GetMapping("/size")
	public ResponseEntity<List<SizeDto>> getAllSizes() {
		List<SizeDto> res = sizeService.getAll();
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/size/{id}")
	public ResponseEntity<SizeDto> getSize(@PathVariable int id) {
		SizeDto size = sizeService.get(id);
		if (size == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(size, HttpStatus.OK);		
	}
}
