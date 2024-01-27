package com.alejandromo.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoe")
public class Shoe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shoe")
	private int idShoe;

	@ManyToOne
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = false, length = 290)
	private String description;

	@Column(name = "price", nullable = false, precision = 5, scale = 2)
	private BigDecimal price;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(
		name = "shoe_color",
		joinColumns = { @JoinColumn(name = "id_shoe") },
		inverseJoinColumns = { @JoinColumn(name = "id_color") }
	)
	Set<Color> colors = new HashSet<>();
	
	// Constructors
	public Shoe() {

	}

	public Shoe(String name, String description, BigDecimal price, Category category) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	// Getters and setters
	public int getIdShoe() {
		return idShoe;
	}

	public void setIdShoe(int idShoe) {
		this.idShoe = idShoe;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}

}