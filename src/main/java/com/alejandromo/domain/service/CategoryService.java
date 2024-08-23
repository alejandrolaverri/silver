package com.alejandromo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.dto.CategoryDto;
import com.alejandromo.domain.repository.ICategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	public List<CategoryDto> getAll() {
		return categoryRepository.getAll();
	}
	
	public CategoryDto getCategory(int idCategory) {
		return categoryRepository.getCategory(idCategory);
	}
	
	public CategoryDto save(CategoryDto category) {
		return categoryRepository.save(category);
	}
	
	public boolean delete(int idCategory) {
		try {
			categoryRepository.delete(idCategory);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
	}

	public List<CategoryDto> getByName(String name) {
		return categoryRepository.getByName(name);
	}

	public List<CategoryDto> saveAll(List<CategoryDto> categories) {
		return categoryRepository.saveAll(categories);
	}
	
}