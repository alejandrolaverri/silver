package com.alejandromo.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int idCategory;

    @Column(name = "name", nullable = false, length = 30)
    private String name;
    
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ShoeEntity> shoes;

    // Constructor vacío
    public CategoryEntity() {}

    // Constructor con parámetros
    public CategoryEntity(int idCategory, String name) {
        this.name = name;
    }
    
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

	public List<ShoeEntity> getShoes() {
		return shoes;
	}

	@Override
	public String toString() {
		return "CategoryEntity [idCategory=" + idCategory + ", name=" + name + ", shoes=" + shoes + "]";
	}

}