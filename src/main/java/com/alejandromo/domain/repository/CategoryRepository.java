package com.alejandromo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.alejandromo.domain.Category;

public interface CategoryRepository {
	List<Category> getAll();
	Optional<Category> getCategory(int idCategory);
	Category save(Category category);
	void delete(int idCategory);
}
