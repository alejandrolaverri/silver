package com.alejandromo.domain.repository;

import java.util.List;

import com.alejandromo.domain.dto.ShoeDto;

public interface IShoeRepository {
	ShoeDto getShoe(int idShoe);
	List<ShoeDto> getAllShoes();
	List<ShoeDto> getByName(String name);
	List<ShoeDto> getByDescription(String description);
	List<ShoeDto> getByNameOrDescription(String name, String description);
	List<ShoeDto> getByCategory(int idCategory);
	ShoeDto save(ShoeDto shoe);
	void delete(int idShoe);
	boolean existsShoeInCategory(int idCategory);
}