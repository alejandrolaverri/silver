package com.alejandromo.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "color")
public class ColorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_color")
	private int idColor;

	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "color")
    @JsonIgnore
    private List<ShoeColorSizeEntity> shoeColorSize;

	// Constructors
	public ColorEntity() {
	}

	public ColorEntity(String name) {
		this.name = name;
	}

	// Getters and setters
	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ShoeColorSizeEntity> getShoeColorSize() {
		return shoeColorSize;
	}

	public void setShoeColorSize(List<ShoeColorSizeEntity> shoeColorSize) {
		this.shoeColorSize = shoeColorSize;
	}

}
