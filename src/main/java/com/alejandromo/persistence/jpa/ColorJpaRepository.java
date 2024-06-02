package com.alejandromo.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.Color;

public interface ColorJpaRepository extends JpaRepository<Color, Integer> {
	List<Color> findByNameContaining(String name);
}