package com.alejandromo.domain.repository;

import java.util.List;

import com.alejandromo.domain.dto.CategoryDto;

public interface ICategoryRepository {
    CategoryDto getCategory(int idCategory);
	List<CategoryDto> getByName(String name);
    List<CategoryDto> getAll();
    CategoryDto save(CategoryDto category);
	List<CategoryDto> saveAll(List<CategoryDto> categories);
    void delete(int idCategory);
}
