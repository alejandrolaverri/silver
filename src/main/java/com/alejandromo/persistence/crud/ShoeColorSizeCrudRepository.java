package com.alejandromo.persistence.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alejandromo.persistence.entity.ShoeColorSizeEntity;

import jakarta.transaction.Transactional;

public interface ShoeColorSizeCrudRepository extends JpaRepository<ShoeColorSizeEntity, Integer> {
    
	@Modifying
    @Transactional
    @Query("DELETE FROM ShoeColorSizeEntity scs WHERE scs.shoe.idShoe = :idShoe AND scs.color.idColor = :idColor")
    int deleteByShoeIdAndColorId(@Param("idShoe") int idShoe, @Param("idColor") int idColor);
	
    boolean existsByColorIdColor(int id);
    
    List<ShoeColorSizeEntity> findByShoeIdShoe(int idShoe);

}