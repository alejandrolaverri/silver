package com.alejandromo.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alejandromo.persistence.entity.Size;

public interface SizeJpaRepository extends JpaRepository<Size, Integer>{

}
