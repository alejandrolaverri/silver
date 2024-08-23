package com.alejandromo.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alejandromo.domain.dto.ShoeDto;
import com.alejandromo.domain.repository.IShoeRepository;
import com.alejandromo.persistence.crud.ShoeCrudRepository;
import com.alejandromo.persistence.entity.ShoeEntity;
import com.alejandromo.persistence.mapper.ShoeMapper;

@Repository
public class ShoeRepository implements IShoeRepository {

	@Autowired
	private ShoeCrudRepository shoeCrudRepository;
	
	@Autowired
	private ShoeMapper shoeMapper;
	
	@Override
	public ShoeDto getShoe(int idShoe) {
		ShoeEntity shoeEntity = shoeCrudRepository.findById(idShoe).orElse(null);
		
		if (shoeEntity != null) {
			ShoeDto shoe = shoeMapper.toShoe(shoeEntity);
			return shoe;
		}
		return null;
	}

	@Override
	public List<ShoeDto> getAllShoes() {
		return shoeMapper.toShoes(shoeCrudRepository.findAll());		
	}

	@Override
	public List<ShoeDto> getByName(String name) {
		return shoeMapper.toShoes(shoeCrudRepository.findByNameContaining(name));		
	}

	@Override
	public List<ShoeDto> getByDescription(String description) {
		return shoeMapper.toShoes(shoeCrudRepository.findByDescriptionContaining(description));
	}

	@Override
	public List<ShoeDto> getByNameOrDescription(String name, String description) {
		return shoeMapper.toShoes(shoeCrudRepository.findByNameContainingOrDescriptionContaining(name, description));
	}

	@Override
	public List<ShoeDto> getByCategory(int idCategory) {
		return shoeMapper.toShoes(shoeCrudRepository.findByCategoryIdCategory(idCategory));
	}

	@Override
	public ShoeDto save(ShoeDto shoe) {
		ShoeEntity shoeEntity = shoeMapper.toShoeEntity(shoe);
		return shoeMapper.toShoe(shoeCrudRepository.save(shoeEntity));
	}

	@Override
	public void delete(int idShoe) {
		shoeCrudRepository.deleteById(idShoe);
	}

	@Override
	public boolean existsShoeInCategory(int idCategory) {
		return shoeCrudRepository.existsByCategoryIdCategory(idCategory);
	}
}
