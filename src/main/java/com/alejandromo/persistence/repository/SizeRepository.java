package com.alejandromo.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alejandromo.domain.dto.SizeDto;
import com.alejandromo.domain.repository.ISizeRepository;
import com.alejandromo.persistence.crud.SizeCrudRepository;
import com.alejandromo.persistence.entity.SizeEntity;
import com.alejandromo.persistence.mapper.SizeMapper;

@Repository
public class SizeRepository implements ISizeRepository {

	@Autowired
	private SizeCrudRepository sizeCrudRepository;
	
	@Autowired
	private SizeMapper sizeMapper;

	@Override
	public SizeDto getSize(int idSize) {
		SizeEntity sizeEntity = sizeCrudRepository.findById(idSize)
												  .orElse(null);
		if (sizeEntity != null) {
			return sizeMapper.toSizeDto(sizeEntity);
		}
		return null;
	}

	@Override
	public List<SizeDto> getAll() {
		return sizeMapper.toSizesDto(sizeCrudRepository.findAll());
	}
	
	@Override
	public SizeDto save(SizeDto size) {
		return sizeMapper.toSizeDto(sizeMapper.toSizeEntity(size));
	}

	@Override
	public void delete(int idSize) {
		sizeCrudRepository.deleteById(idSize);
	}
	
}
