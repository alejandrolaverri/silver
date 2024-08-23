package com.alejandromo.domain.repository;

import java.util.List;

import com.alejandromo.domain.dto.SizeDto;

public interface ISizeRepository {
	SizeDto getSize(int idSize);
	List<SizeDto> getAll();
	SizeDto save(SizeDto size);
	void delete(int idSize);
}
