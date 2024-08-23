package com.alejandromo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoe_color_size")
public class ShoeColorSizeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shoe_color_size")
	private int idShoeColorSize;
	
    @ManyToOne
    @JoinColumn(name = "id_shoe", referencedColumnName = "id_shoe", insertable = false, updatable = false)
    @JsonIgnore
    private ShoeEntity shoe;

    @ManyToOne
    @JoinColumn(name = "id_color", referencedColumnName = "id_color", insertable = false, updatable = false)
    @JsonBackReference
    private ColorEntity color;

    @ManyToOne
    @JoinColumn(name = "id_size", referencedColumnName = "id_size", insertable = false, updatable = false)
    @JsonBackReference
    private SizeEntity size;
    
	@Column(name = "stock")
	private int stock;

    // Contructors
    public ShoeColorSizeEntity() {
    	
    }
    
	public ShoeColorSizeEntity(int idShoeColorSize, ShoeEntity shoe, ColorEntity color, SizeEntity size, int stock) {
		this.idShoeColorSize = idShoeColorSize;
		this.stock = stock;
		this.shoe = shoe;
		this.color = color;
		this.size = size;
	}

	// Getters and Setters
	public int getIdShoeColorSize() {
		return idShoeColorSize;
	}

	public void setIdShoeColor(int idShoeColorSize) {
		this.idShoeColorSize = idShoeColorSize;
	}

	public ShoeEntity getShoe() {
		return shoe;
	}

	public void setShoe(ShoeEntity shoe) {
		this.shoe = shoe;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public SizeEntity getSize() {
		return size;
	}

	public void setSize(SizeEntity size) {
		this.size = size;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}	
}
