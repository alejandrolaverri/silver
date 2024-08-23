package com.alejandromo.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.ShoeEntity;

public interface ShoeCrudRepository extends JpaRepository<ShoeEntity, Integer> {
	List<ShoeEntity> findByNameContaining(String name);
	List<ShoeEntity> findByDescriptionContaining(String description);
	List<ShoeEntity> findByNameContainingOrDescriptionContaining(String name, String description);
	List<ShoeEntity> findByCategoryIdCategory(int id);
    List<ShoeEntity> findByShoeColorSize_Size_IdSizeAndShoeColorSize_Color_IdColorAndCategory_IdCategory(int idSize, int idColor, int idCategory);
	boolean existsByCategoryIdCategory(int id);
}