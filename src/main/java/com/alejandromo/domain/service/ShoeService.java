package com.alejandromo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.dto.ShoeDto;
import com.alejandromo.domain.repository.IShoeRepository;

@Service
public class ShoeService {
	
	@Autowired
	private IShoeRepository shoeRepository;

	public List<ShoeDto> getByNameOrDescription(String name, String description) {
		if (name != null && description != null) {
			return shoeRepository.getByNameOrDescription(name, description);
		} else if (name != null && description == null) {
			return shoeRepository.getByName(name);
		} else if (name == null && description != null) {
			return shoeRepository.getByDescription(description);
		} else {
			return shoeRepository.getAllShoes();
		}
	}
	
	public ShoeDto get(int idShoe) {
		return shoeRepository.getShoe(idShoe);
	}
	
	public ShoeDto save(ShoeDto shoe) {
		return shoeRepository.save(shoe);
	}
	
	public List<ShoeDto> getByCategory(int idCategory) {
		return shoeRepository.getByCategory(idCategory);
	}
	
	public boolean delete(int idShoe) {
		try {
			shoeRepository.delete(idShoe);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
	
	public boolean existsShoesInCategory(int idCategory) {
		return shoeRepository.existsShoeInCategory(idCategory);		
	}
}