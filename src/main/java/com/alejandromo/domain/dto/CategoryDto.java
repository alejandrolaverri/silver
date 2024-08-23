package com.alejandromo.domain.dto;

public class CategoryDto {
	private Integer idCategory;
	private String name;
	
	public Integer getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", name=" + name + "]";
	}
}
