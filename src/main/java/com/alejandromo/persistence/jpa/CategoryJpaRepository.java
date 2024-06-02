package com.alejandromo.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {
	List<Category> findByNameContaining(String name);
}
