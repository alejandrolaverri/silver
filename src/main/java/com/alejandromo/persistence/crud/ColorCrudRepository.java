package com.alejandromo.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.ColorEntity;

public interface ColorCrudRepository extends JpaRepository<ColorEntity, Integer> {
	List<ColorEntity> findByNameContaining(String name);
}