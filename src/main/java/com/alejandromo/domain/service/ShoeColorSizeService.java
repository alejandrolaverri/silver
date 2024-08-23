package com.alejandromo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.dto.ShoeColorSizeDto;
import com.alejandromo.domain.repository.IShoeColorSizeRepository;

@Service
public class ShoeColorSizeService {
	
	@Autowired
	private IShoeColorSizeRepository shoeColorSizeRepository;
	
	public List<ShoeColorSizeDto> getDetailsShoe(int idShoe) {
		return shoeColorSizeRepository.getDetailsShoe(idShoe);
	}
	
	public ShoeColorSizeDto save(ShoeColorSizeDto shoeColorSize) {
		return shoeColorSizeRepository.save(shoeColorSize);
	}
	
	public int deleteColor(int idShoe, int idColor) {
		return shoeColorSizeRepository.deleteColor(idShoe, idColor);
	}

	public boolean colorUsed(int idColor) {
		return shoeColorSizeRepository.usedColor(idColor);
		
	}
}
