package com.alejandromo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
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

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", name=" + name + ", shoes=" + shoes + "]";
	}

}