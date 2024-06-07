package com.alejandromo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.alejandromo.domain.ShoeColorSize;

public interface ShoeColorSizeRepository {
	Optional<List<ShoeColorSize>> getByShoe(int idShoe);
	Optional<List<ShoeColorSize>> getByColor(int idColor);
	Optional<List<ShoeColorSize>> getBySize(int idSize);
	
	ShoeColorSize save(ShoeColorSize shoeColorSize);
	void delete(int idShoeColorSize);
}
