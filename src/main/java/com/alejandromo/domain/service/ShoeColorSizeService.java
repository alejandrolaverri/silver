package com.alejandromo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.repository.ShoeColorSizeRepository;
import com.alejandromo.domain.ShoeColorSize;

@Service
public class ShoeColorSizeService {
	
	@Autowired
	private ShoeColorSizeRepository shoeColorSizeRepository;
	
	
	public Optional<List<ShoeColorSize>> getByShoe(int idShoe) {
        return shoeColorSizeRepository.getByShoe(idShoe);
    }
	
	public Optional<List<ShoeColorSize>> getByColor(int idColor) {
        return shoeColorSizeRepository.getByColor(idColor);
    }
	
	public Optional<List<ShoeColorSize>> getBySize(int idSize) {
        return shoeColorSizeRepository.getBySize(idSize);
    }
	
}
