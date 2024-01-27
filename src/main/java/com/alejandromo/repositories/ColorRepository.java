package com.alejandromo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
