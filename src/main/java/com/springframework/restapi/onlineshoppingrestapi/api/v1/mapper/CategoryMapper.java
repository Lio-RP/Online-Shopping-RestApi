package com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    @Mapping(target = "id", ignore = true)
    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
