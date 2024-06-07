package com.alejandromo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.Shoe;
import com.alejandromo.domain.repository.ShoeRepository;

@Service
public class ShoeService {
	
	@Autowired
    private ShoeRepository shoeRepository;
	
	public List<Shoe> getAll() {
		return shoeRepository.getAll();
	}
	
	public Optional<Shoe> getShoe(int idShoe) {
		return shoeRepository.getShoe(idShoe);
	}
	
	public Shoe save(Shoe shoe) {
		return shoeRepository.save(shoe);
	}
	
	public boolean delete(int idShoe) {
		try {
			shoeRepository.delete(idShoe);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
	
}
