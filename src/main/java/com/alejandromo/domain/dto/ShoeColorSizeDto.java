package com.alejandromo.domain.dto;

public class ShoeColorSizeDto {
	private Integer idShoeColorSize;
	private ColorDto color;
	private SizeDto size;
	private Integer stock;
	
	public Integer getIdShoeColorSize() {
		return idShoeColorSize;
	}
	public void setIdShoeColorSize(Integer idShoeColorSize) {
		this.idShoeColorSize = idShoeColorSize;
	}
	public ColorDto getColor() {
		return color;
	}
	public void setColor(ColorDto color) {
		this.color = color;
	}
	public SizeDto getSize() {
		return size;
	}
	public void setSize(SizeDto size) {
		this.size = size;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
