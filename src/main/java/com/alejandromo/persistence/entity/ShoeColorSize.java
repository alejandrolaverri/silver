package com.alejandromo.persistence.entity;

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
public class ShoeColorSize {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_shoe_color")
	private int idShoeColor;
	
    @ManyToOne
    @JoinColumn(name = "id_shoe", referencedColumnName = "id_shoe", insertable = false, updatable = false)
    private Shoe shoe;

    @ManyToOne
    @JoinColumn(name = "id_color", referencedColumnName = "id_color", insertable = false, updatable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "id_size", referencedColumnName = "id_size", insertable = false, updatable = false)
    private Size size;
    
	@Column(name = "stock")
	private int stock;

    // Contrutors
    public ShoeColorSize() {
    	
    }
    
	public ShoeColorSize(int idShoeColor, Shoe shoe, Color color, Size size, int stock) {
		this.idShoeColor = idShoeColor;
		this.stock = stock;
		this.shoe = shoe;
		this.color = color;
		this.size = size;
	}

	// Getters and Setters
	public int getIdShoeColor() {
		return idShoeColor;
	}

	public void setIdShoeColor(int idShoeColor) {
		this.idShoeColor = idShoeColor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Shoe getShoe() {
		return shoe;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
}
