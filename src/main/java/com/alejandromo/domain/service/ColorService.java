package com.alejandromo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.dto.ColorDto;
import com.alejandromo.domain.repository.IColorRepository;

@Service
public class ColorService {
	
	@Autowired
	private IColorRepository colorRepository;
	
	public ColorDto get(int idColor) {
		return colorRepository.getColor(idColor);		
	}
	
	public List<ColorDto> getByName(String name) {
		return colorRepository.getByName(name);
	}
	
	public List<ColorDto> getAll() {
		return colorRepository.getAll();
	}
	
	public ColorDto save(ColorDto colorDto) {
		return colorRepository.save(colorDto);
	}
	
	public List<ColorDto> saveAll(List<ColorDto> colors) {
		return colorRepository.saveAll(colors);
	}
	
	public boolean delete(int idColor) {
		try {
			colorRepository.delete(idColor);
			return true;
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
	}
}
