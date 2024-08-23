package com.alejandromo.domain.repository;

import java.util.List;

import com.alejandromo.domain.dto.ShoeColorSizeDto;

public interface IShoeColorSizeRepository {
	ShoeColorSizeDto save(ShoeColorSizeDto shoeColorSize);
	List<ShoeColorSizeDto> getDetailsShoe(int idShoe);
	boolean usedColor(int idColor);
	int deleteColor(int idShoe, int idColor);
}
