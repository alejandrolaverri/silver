package com.alejandromo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.dto.SizeDto;
import com.alejandromo.domain.repository.ISizeRepository;

@Service
public class SizeService {
	@Autowired
	private ISizeRepository sizeRepository;
	
	public SizeDto get(int idSize) {
		return sizeRepository.getSize(idSize);
	}
	
	public List<SizeDto> getAll() {
		return sizeRepository.getAll();
	}
	
	public SizeDto save(SizeDto size) {
		return sizeRepository.save(size);
	}
	
	public boolean delete(int idSize) {
		try {
			sizeRepository.delete(idSize);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}
