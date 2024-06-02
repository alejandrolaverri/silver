package com.alejandromo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.models.Color;
import com.alejandromo.models.Shoe;
import com.alejandromo.models.ShoeColorSize;
import com.alejandromo.models.Size;
import com.alejandromo.repositories.ColorRepository;
import com.alejandromo.repositories.ShoeColorSizeRepository;
import com.alejandromo.repositories.ShoeRepository;
import com.alejandromo.repositories.SizeRepository;

@RestController
@RequestMapping(path="/api")
public class ShoeColorSizeController {
	
	@Autowired
	private ShoeRepository shoeRepository;

	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private SizeRepository sizeRepository;
	
	@Autowired
	private ShoeColorSizeRepository shoeColorSizeRepository;

	@PostMapping("/shoe/{idshoe}/size/{idsize}/color/{idcolor}")
	public ResponseEntity<ShoeColorSize> addModelShoe(@PathVariable("idshoe") int idShoe,
									@PathVariable("idsize") int idSize,
									@PathVariable("idcolor") int idColor,
									@RequestBody int stock) {
		Shoe shoe = shoeRepository.findById(idShoe).orElse(null);
		Size size = sizeRepository.findById(idSize).orElse(null);
		Color color = colorRepository.findById(idColor).orElse(null);
		
		if (shoe == null || size ==null || color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ShoeColorSize shoeColorSize = new ShoeColorSize();
		shoeColorSize.setColor(color);
		shoeColorSize.setSize(size);
		shoeColorSize.setShoe(shoe);
		shoeColorSize.setStock(stock);
		
		return new ResponseEntity<>(shoeColorSizeRepository.save(shoeColorSize), HttpStatus.OK);
	}
	
	@DeleteMapping("/shoe/{idshoe}/color/{idcolor}")
	public ResponseEntity<Shoe> deleteShoeColor(@PathVariable("idshoe") int idShoe,
			@PathVariable("idcolor") int idColor) {
		Shoe shoe = shoeRepository.findById(idShoe).orElse(null);
		Color color = colorRepository.findById(idColor).orElse(null);
		if (shoe == null || color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (shoeColorSizeRepository.deleteByShoeIdAndColorId(idShoe, idColor) == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
