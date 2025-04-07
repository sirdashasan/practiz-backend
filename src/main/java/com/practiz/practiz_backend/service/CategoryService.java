package com.practiz.practiz_backend.service;

import com.practiz.practiz_backend.dto.CategoryDto;
import com.practiz.practiz_backend.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
