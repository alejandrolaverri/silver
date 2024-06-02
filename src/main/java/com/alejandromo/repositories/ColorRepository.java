package com.alejandromo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {
	List<Color> findByNameContaining(String name);
}