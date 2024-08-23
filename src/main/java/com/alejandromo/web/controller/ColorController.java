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

import com.alejandromo.domain.dto.ColorDto;
import com.alejandromo.domain.service.ColorService;
import com.alejandromo.domain.service.ShoeColorSizeService;

@RestController
@RequestMapping(path="/api")
public class ColorController {
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private ShoeColorSizeService shoeColorSizeService;
	
	@GetMapping("/color")
	public ResponseEntity<List<ColorDto>> getAllColors(@RequestParam(required = false) String name) {
		List<ColorDto> res = new ArrayList<>();
		if (name == null) {
			res = colorService.getAll();
		} else {
			res = colorService.getByName(name);
		}
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/color/{id}")
	public ResponseEntity<ColorDto> getColor(@PathVariable int id) {
		ColorDto color = colorService.get(id);
		if (color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(color, HttpStatus.OK);	
	}
	
	@PostMapping("/color")
	public ResponseEntity<ColorDto> addColor(@RequestBody ColorDto colorDto) {
		return new ResponseEntity<>(colorService.save(colorDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/colors")
	public ResponseEntity<List<ColorDto>> addColors(@RequestBody List<ColorDto> colors) {
		if (colors.size() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(colorService.saveAll(colors), HttpStatus.CREATED);
	}
	
	@PutMapping("/color/{id}")
	public ResponseEntity<ColorDto> updateColor(@PathVariable int id, @RequestBody ColorDto color) {
		ColorDto temp = colorService.get(id);
		if (temp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else if (temp.getIdColor() != color.getIdColor()) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} else {
			BeanUtils.copyProperties(color, temp);
			return new ResponseEntity<>(colorService.save(temp), HttpStatus.OK);	
		}
	}
	
	@DeleteMapping("/color/{id}")
	public ResponseEntity<HttpStatus> deleteColor(@PathVariable int id) {
		ColorDto color = colorService.get(id);
		if (color == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (shoeColorSizeService.colorUsed(id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		colorService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
