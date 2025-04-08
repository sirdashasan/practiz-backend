package com.practiz.practiz_backend.mapper;

import com.practiz.practiz_backend.dto.SubCategoryDto;
import com.practiz.practiz_backend.entity.Category;
import com.practiz.practiz_backend.entity.SubCategory;

public class SubCategoryMapper {

    public static SubCategoryDto toDto(SubCategory subCategory) {
        return new SubCategoryDto(
                subCategory.getId(),
                subCategory.getName(),
                subCategory.getCategory().getId()
        );
    }

    public static SubCategory toEntity(SubCategoryDto dto, Category category) {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(dto.getId());
        subCategory.setName(dto.getName());
        subCategory.setCategory(category);
        return subCategory;
    }
}
