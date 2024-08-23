package com.alejandromo.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alejandromo.domain.dto.ColorDto;
import com.alejandromo.domain.repository.IColorRepository;
import com.alejandromo.persistence.crud.ColorCrudRepository;
import com.alejandromo.persistence.entity.ColorEntity;
import com.alejandromo.persistence.mapper.ColorMapper;

@Repository
public class ColorRepository implements IColorRepository {
	
	@Autowired
	private ColorCrudRepository colorCrudRepository;
	
	@Autowired
	private ColorMapper colorMapper;

	@Override
	public ColorDto getColor(int idColor) {
		ColorEntity colorEntity = colorCrudRepository.findById(idColor)
				  									 .orElse(null);

		if (colorEntity != null) {
			return colorMapper.toColorDto(colorEntity);
		}
		return null;
	}
	
	@Override
	public List<ColorDto> getByName(String name) {
		List<ColorEntity> newColorsEntity = colorCrudRepository.findByNameContaining(name);
		if (newColorsEntity != null) {
			return colorMapper.toColorsDto(newColorsEntity);
		}
		return null;
	}

	@Override
	public List<ColorDto> getAll() {
		List<ColorEntity> colorsEntity = colorCrudRepository.findAll();
		if (colorsEntity != null) {
			return colorMapper.toColorsDto(colorsEntity);
		}
		return null;
	}

	@Override
	public ColorDto save(ColorDto color) {
		ColorEntity newColorEntity = colorMapper.toCategoryEntity(color);
		return colorMapper.toColorDto(colorCrudRepository.save(newColorEntity));
	}
	
	@Override
	public List<ColorDto> saveAll(List<ColorDto> colors) {
		List<ColorEntity> newColorsEntity = colorMapper.toCategoriesEntity(colors);
		return colorMapper.toColorsDto(colorCrudRepository.saveAll(newColorsEntity));
	}

	@Override
	public void delete(int idColor) {
		colorCrudRepository.deleteById(idColor);
	}

}
