package com.alejandromo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {

}
