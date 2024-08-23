package com.alejandromo.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alejandromo.domain.dto.ShoeColorSizeDto;
import com.alejandromo.domain.repository.IShoeColorSizeRepository;
import com.alejandromo.persistence.crud.ShoeColorSizeCrudRepository;
import com.alejandromo.persistence.entity.ShoeColorSizeEntity;
import com.alejandromo.persistence.mapper.ShoeColorSizeMapper;

@Repository
public class ShoeColorSizeRepository implements IShoeColorSizeRepository {

	@Autowired
	private ShoeColorSizeCrudRepository shoeColorSizeCrudRepository;
	
	@Autowired
	private ShoeColorSizeMapper shoeColorSizeMapper;
	
	@Override
	public ShoeColorSizeDto save(ShoeColorSizeDto shoeColorSize) {
		ShoeColorSizeEntity shoeColorSizeEntity = shoeColorSizeMapper.toShoeColorSizeEntity(shoeColorSize);
		return shoeColorSizeMapper.toShoeColorSizeDto(shoeColorSizeCrudRepository.save(shoeColorSizeEntity));
	}

	@Override
	public int deleteColor(int idShoe, int idColor) {
		return shoeColorSizeCrudRepository.deleteByShoeIdAndColorId(idShoe, idColor);
	}

	@Override
	public boolean usedColor(int idColor) {
		return shoeColorSizeCrudRepository.existsByColorIdColor(idColor);
	}

	@Override
	public List<ShoeColorSizeDto> getDetailsShoe(int idShoe) {
		return shoeColorSizeMapper.toShoesColorsSizesDto(shoeColorSizeCrudRepository.findByShoeIdShoe(idShoe));
	}

}
