package com.alejandromo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.alejandromo.domain.dto.ColorDto;
import com.alejandromo.persistence.entity.ColorEntity;

@Mapper(componentModel = "spring")
public interface ColorMapper {
	@Mappings({
		@Mapping(source = "idColor", target = "idColor"),
        @Mapping(source = "name", target = "name"),
	})
	ColorDto toColorDto(ColorEntity color);
	List<ColorDto> toColorsDto(List<ColorEntity> colors);
	
    @InheritInverseConfiguration
    @Mapping(target = "shoeColorSize", ignore = true)
    ColorEntity toCategoryEntity(ColorDto colors);
	List<ColorEntity> toCategoriesEntity(List<ColorDto> colors);
}
