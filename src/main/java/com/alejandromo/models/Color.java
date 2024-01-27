package com.alejandromo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_color")
	private int idColor;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "colors")
	@JsonIgnore
	private Set<Shoe> shoes = new HashSet<>();

	// Constructors
	public Color() {

	}

	public Color(String name) {
		this.name = name;
	}

	// Getters and setters
	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
