package com.alejandromo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
