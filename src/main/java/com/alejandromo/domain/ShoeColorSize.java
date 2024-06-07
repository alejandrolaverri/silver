package com.alejandromo.domain;

public class ShoeColorSize {
	
	private int idShoeColorSize;
	private int idShoe;
	private int idColor;
	private int idSize;
	private int stock;
	
	private Shoe shoe;
	private Size size;
	private Color color;
	
	public int getIdShoeColorSize() {
		return idShoeColorSize;
	}
	
	public void setIdShoeColorSize(int idShoeColorSize) {
		this.idShoeColorSize = idShoeColorSize;
	}
	
	public int getIdShoe() {
		return idShoe;
	}
	
	public void setIdShoe(int idShoe) {
		this.idShoe = idShoe;
	}
	
	public int getIdColor() {
		return idColor;
	}
	
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	
	public int getIdSize() {
		return idSize;
	}
	
	public void setIdSize(int idSize) {
		this.idSize = idSize;
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
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
