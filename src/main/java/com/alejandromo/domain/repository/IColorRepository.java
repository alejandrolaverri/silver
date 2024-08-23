package com.alejandromo.domain.repository;

import java.util.List;

import com.alejandromo.domain.dto.ColorDto;

public interface IColorRepository {
	ColorDto getColor(int idColor);
	List<ColorDto> getByName(String name);
	List<ColorDto> getAll();
	ColorDto save(ColorDto shoe);
	List<ColorDto> saveAll(List<ColorDto> colors);
	void delete(int idColor);
}
