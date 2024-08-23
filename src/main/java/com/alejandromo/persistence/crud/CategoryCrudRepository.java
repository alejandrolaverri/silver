package com.alejandromo.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.CategoryEntity;

public interface CategoryCrudRepository extends JpaRepository<CategoryEntity, Integer> {
	List<CategoryEntity> findByNameContaining(String name);
}
