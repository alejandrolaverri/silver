package com.alejandromo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandromo.domain.dto.ColorDto;
import com.alejandromo.domain.dto.ShoeDto;
import com.alejandromo.domain.dto.ShoeColorSizeDto;
import com.alejandromo.domain.dto.SizeDto;
import com.alejandromo.domain.service.ColorService;
import com.alejandromo.domain.service.ShoeColorSizeService;
import com.alejandromo.domain.service.ShoeService;
import com.alejandromo.domain.service.SizeService;

@RestController
@RequestMapping(path="/api")
public class ShoeColorSizeController {
	
	@Autowired
	private ShoeColorSizeService shoeColorSizeService;
	
	@Autowired
	private ShoeService shoeService;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private ColorService colorService;
	
	@GetMapping("/shoe/{idshoe}/details")
	public ResponseEntity<List<ShoeColorSizeDto>> getDetailsShoe(@PathVariable("idshoe") int idShoe) {
		ShoeDto shoe = shoeService.get(idShoe);
		
		if (shoe == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<ShoeColorSizeDto>>(shoeColorSizeService.getDetailsShoe(idShoe), HttpStatus.OK);
	}

	@PostMapping("/shoe/{idshoe}/size/{idsize}/color/{idcolor}")
	public ResponseEntity<ShoeColorSizeDto> addModelShoe(@PathVariable("idshoe") int idShoe,
									@PathVariable("idsize") int idSize,
									@PathVariable("idcolor") int idColor,
									@RequestBody int stock) {
		ShoeDto shoe = shoeService.get(idShoe);
		SizeDto size = sizeService.get(idSize);
		ColorDto color = colorService.get(idColor);
		
		if (shoe == null || size ==null || color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ShoeColorSizeDto shoeColorSize = new ShoeColorSizeDto();
		shoeColorSize.setColor(color);
		shoeColorSize.setSize(size);
		shoeColorSize.setStock(stock);
		
		return new ResponseEntity<ShoeColorSizeDto>(shoeColorSizeService.save(shoeColorSize), HttpStatus.OK);
	}
	
	@DeleteMapping("/shoe/{idshoe}/color/{idcolor}")
	public ResponseEntity<HttpStatus> deleteShoeColor(@PathVariable("idshoe") int idShoe,
													  @PathVariable("idcolor") int idColor) {
		ShoeDto shoe = shoeService.get(idShoe);
		ColorDto color = colorService.get(idColor);
		if (shoe == null || color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (shoeColorSizeService.deleteColor(idShoe, idColor) == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
