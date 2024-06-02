package com.alejandromo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alejandromo.models.ShoeColorSize;

import jakarta.transaction.Transactional;

public interface ShoeColorSizeRepository extends JpaRepository<ShoeColorSize, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ShoeColorSize scs WHERE scs.shoe.idShoe = :idShoe AND scs.color.idColor = :idColor")
    int deleteByShoeIdAndColorId(@Param("idShoe") int idShoe, @Param("idColor") int idColor);
    
    boolean existsByColorIdColor(int id);
    
}
