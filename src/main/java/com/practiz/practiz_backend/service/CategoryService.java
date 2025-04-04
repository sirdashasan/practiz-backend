package com.practiz.practiz_backend.service;

import com.practiz.practiz_backend.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
}
