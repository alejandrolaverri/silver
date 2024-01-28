package com.alejandromo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.models.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {
	List<Shoe> findByNameContaining(String name);
	List<Shoe> findByDescriptionContaining(String description);
	List<Shoe> findByNameContainingOrDescriptionContaining(String name, String description);
	List<Shoe> findByCategoryIdCategory(int id);
	boolean existsByCategoryIdCategory(int id);
}
