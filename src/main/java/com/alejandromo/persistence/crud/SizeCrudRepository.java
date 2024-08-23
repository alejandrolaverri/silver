package com.alejandromo.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.SizeEntity;

public interface SizeCrudRepository extends JpaRepository<SizeEntity, Integer>{

}
