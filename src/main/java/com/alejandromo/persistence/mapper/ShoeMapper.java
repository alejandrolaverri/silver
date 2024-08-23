package com.alejandromo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.alejandromo.domain.dto.ShoeDto;
import com.alejandromo.persistence.entity.ShoeEntity;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ShoeMapper {
	@Mappings({
		@Mapping(source = "idShoe", target = "idShoe"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "description", target = "description"),
        @Mapping(source = "price", target = "price"),
        @Mapping(source = "category", target = "category")
	})
	ShoeDto toShoe(ShoeEntity shoe);
    List<ShoeDto> toShoes(List<ShoeEntity> shoes);

    @InheritInverseConfiguration
    @Mapping(target = "shoeColorSize", ignore = true)
    ShoeEntity toShoeEntity(ShoeDto shoeDto);
	List<ShoeEntity> toShoesEntity(List<ShoeDto> shoesDtos);
}
