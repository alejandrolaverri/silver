package com.alejandromo.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.Shoe;

public interface ShoeJpaRepository extends JpaRepository<Shoe, Integer> {
	List<Shoe> findByNameContaining(String name);
	List<Shoe> findByDescriptionContaining(String description);
	List<Shoe> findByNameContainingOrDescriptionContaining(String name, String description);
	List<Shoe> findByCategoryIdCategory(int id);
	boolean existsByCategoryIdCategory(int id);
}