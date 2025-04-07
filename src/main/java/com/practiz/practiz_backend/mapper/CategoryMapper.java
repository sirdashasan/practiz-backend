package com.practiz.practiz_backend.mapper;

import com.practiz.practiz_backend.dto.CategoryDto;
import com.practiz.practiz_backend.entity.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }

    public static Category toEntity(CategoryDto dto){
        return new Category(dto.getId(), dto.getName());
    }
}
