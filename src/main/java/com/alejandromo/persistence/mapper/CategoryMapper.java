package com.alejandromo.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.alejandromo.domain.dto.CategoryDto;
import com.alejandromo.persistence.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "idCategory"),
            @Mapping(source = "name", target = "name"),
    })
    CategoryDto toCategory(CategoryEntity category);
    List<CategoryDto> toCategories(List<CategoryEntity> categories);

    @InheritInverseConfiguration
    @Mapping(target = "shoes", ignore = true)
    CategoryEntity toCategoryEntity(CategoryDto category);
	List<CategoryEntity> toCategoriesEntity(List<CategoryDto> categories);

}