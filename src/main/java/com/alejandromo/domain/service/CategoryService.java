package com.alejandromo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alejandromo.domain.Category;
import com.alejandromo.domain.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll() {
		return categoryRepository.getAll();
	}
	
	public Optional<Category> getCategory(int idCategory) {
		return categoryRepository.getCategory(idCategory);
	}
	
	public Category save(Category category) {
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
	
}
