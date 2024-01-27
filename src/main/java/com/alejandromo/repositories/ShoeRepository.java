package com.alejandromo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {
	List<Shoe> findByCategoryIdCategory(int id);
	boolean existsByCategoryIdCategory(int id);
}
