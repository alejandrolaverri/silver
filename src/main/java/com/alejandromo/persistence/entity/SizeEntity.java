package com.alejandromo.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "size")
public class SizeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_size")
	private int idSize;

	@Column(name = "number", nullable = false)
	private int number;
	
	@OneToMany(mappedBy = "size")
    @JsonManagedReference
    private List<ShoeColorSizeEntity> shoeColorSize;

	// Constructors
	public SizeEntity() {
	}

	public SizeEntity(int number) {
		this.number = number;
	}

	// Getters and Setters
	public int getIdSize() {
		return idSize;
	}

	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<ShoeColorSizeEntity> getShoeColorSize() {
		return shoeColorSize;
	}

	public void setShoeColorSize(List<ShoeColorSizeEntity> shoeColorSize) {
		this.shoeColorSize = shoeColorSize;
	}

}
