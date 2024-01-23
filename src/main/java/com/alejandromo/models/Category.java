package com.alejandromo.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_category")
	private int idCategory;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Shoe> shoes;

	// Constructors
	public Category() {

	}

	public Category(String name) {
		this.name = name;
	}

	// Getters and setters
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Shoe> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}

}