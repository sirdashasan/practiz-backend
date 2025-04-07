package com.practiz.practiz_backend.service.impl;

import com.practiz.practiz_backend.dto.CategoryDto;
import com.practiz.practiz_backend.entity.Category;
import com.practiz.practiz_backend.exceptions.ApiException;
import com.practiz.practiz_backend.mapper.CategoryMapper;
import com.practiz.practiz_backend.repository.CategoryRepository;
import com.practiz.practiz_backend.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException("Category not found with id: " + id, HttpStatus.NOT_FOUND));

        category.setName(categoryDto.getName());

        Category updated = categoryRepository.save(category);
        return CategoryMapper.toDto(updated);
    }


    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ApiException("Category not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }
}
