package com.alejandromo.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alejandromo.domain.dto.CategoryDto;
import com.alejandromo.domain.repository.ICategoryRepository;
import com.alejandromo.persistence.crud.CategoryCrudRepository;
import com.alejandromo.persistence.entity.CategoryEntity;
import com.alejandromo.persistence.mapper.CategoryMapper;

@Repository
public class CategoryRepository implements ICategoryRepository {
	@Autowired
	private CategoryCrudRepository categoryCrudRepository;
	
	@Autowired
    private CategoryMapper categoryMapper;

	@Override
	public CategoryDto getCategory(int idCategory) {
		CategoryEntity categoryEntity = categoryCrudRepository.findById(idCategory)
															  .orElse(null);
		
		if (categoryEntity != null) {
			return categoryMapper.toCategory(categoryEntity);
		}
		return null;
	}

	@Override
	public List<CategoryDto> getByName(String name) {
		List<CategoryEntity> categoriesEntity = categoryCrudRepository.findByNameContaining(name);
		if (!categoriesEntity.isEmpty()) {
			return categoryMapper.toCategories(categoriesEntity);
		}
		return null;
	}

	@Override
	public List<CategoryDto> getAll() {
		List<CategoryEntity> categoriesEntity = categoryCrudRepository.findAll();
		if (categoriesEntity != null) {
			return categoryMapper.toCategories(categoriesEntity);
		}
		return null;
	}

	@Override
	public CategoryDto save(CategoryDto category) {
		CategoryEntity newCategory = categoryMapper.toCategoryEntity(category);
		return categoryMapper.toCategory(categoryCrudRepository.save(newCategory));
	}

	@Override
	public List<CategoryDto> saveAll(List<CategoryDto> categories) {
		List<CategoryEntity> newCategories = categoryMapper.toCategoriesEntity(categories);
		return categoryMapper.toCategories(categoryCrudRepository.saveAll(newCategories));
	}

	@Override
	public void delete(int idCategory) {
		categoryCrudRepository.deleteById(idCategory);
	}

}
