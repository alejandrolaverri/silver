package com.alejandromo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.alejandromo.domain.dto.SizeDto;
import com.alejandromo.persistence.entity.SizeEntity;

@Mapper(componentModel = "spring")
public interface SizeMapper {
	@Mappings({
        @Mapping(source = "idSize", target = "idSize"),
        @Mapping(source = "number", target = "number"),
	})
	SizeDto toSizeDto(SizeEntity size);
	List<SizeDto> toSizesDto(List<SizeEntity> sizes);
	
	@InheritInverseConfiguration
    @Mapping(target = "shoeColorSize", ignore = true)
	SizeEntity toSizeEntity(SizeDto size);
	List<SizeEntity> toSizesEntity(List<SizeDto> sizes);
}
