package com.alejandromo.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.Genre;


public interface GenreJpaRepository extends JpaRepository<Genre, Integer> {

}
