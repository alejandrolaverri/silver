package com.alejandromo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Genre;


public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
