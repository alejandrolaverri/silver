package com.alejandromo.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoe")
public class ShoeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shoe")
	private int idShoe;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = false, length = 290)
	private String description;

	@Column(name = "price", nullable = false, precision = 5, scale = 2)
	private BigDecimal price;
	
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private CategoryEntity category;
    
    @OneToMany(mappedBy = "shoe")
    @JsonIgnore
    private List<ShoeColorSizeEntity> shoeColorSize;
	
	// Constructors
	public ShoeEntity() {

	}

    public ShoeEntity(String name, String description, BigDecimal price, CategoryEntity category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

	// Getters and setters
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<ShoeColorSizeEntity> getShoeColorSize() {
		return shoeColorSize;
	}

	public void setShoeColorSize(List<ShoeColorSizeEntity> shoeColorSize) {
		this.shoeColorSize = shoeColorSize;
	}

	@Override
	public String toString() {
		return "ShoeEntity [idShoe=" + idShoe + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
}