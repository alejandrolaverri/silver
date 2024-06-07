package com.alejandromo.domain;

import java.math.BigDecimal;
import java.util.List;

public class Shoe {
	
	private int idShoe;
	private String name;
	private String description;
	private BigDecimal price;
	
	private Category category;
	private Genre genre;
	
	private List<ShoeColorSize> shoeColorSize;

	public int getIdShoe() {
		return idShoe;
	}
	
	public void setIdShoe(int idShoe) {
		this.idShoe = idShoe;
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
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public List<ShoeColorSize> getShoeColorSize() {
		return shoeColorSize;
	}

	public void setShoeColorSize(List<ShoeColorSize> shoeColorSize) {
		this.shoeColorSize = shoeColorSize;
	}
	
}
