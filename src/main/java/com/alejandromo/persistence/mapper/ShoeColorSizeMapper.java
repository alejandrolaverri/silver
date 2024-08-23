package com.alejandromo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.alejandromo.domain.dto.ShoeColorSizeDto;
import com.alejandromo.persistence.entity.ShoeColorSizeEntity;

@Mapper(componentModel = "spring", uses = { ShoeMapper.class, ColorMapper.class, SizeMapper.class })
public interface ShoeColorSizeMapper {
	@Mappings({
		@Mapping(source = "idShoeColorSize", target = "idShoeColorSize"),
        @Mapping(source = "color", target = "color"),
        @Mapping(source = "size", target = "size"),
        @Mapping(source = "stock", target = "stock"),
	})
	ShoeColorSizeDto toShoeColorSizeDto(ShoeColorSizeEntity shoe);
    List<ShoeColorSizeDto> toShoesColorsSizesDto(List<ShoeColorSizeEntity> shoes);
    
    @InheritInverseConfiguration
    @Mapping(target = "idShoeColor", ignore = true)
    @Mapping(target = "shoe", ignore = true)
    ShoeColorSizeEntity toShoeColorSizeEntity(ShoeColorSizeDto shoeColorSizeDto);
    List<ShoeColorSizeEntity> toShoesColorsSizesEntity(List<ShoeColorSizeDto> shoeColorSizeDtos);
}
