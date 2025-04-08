package com.practiz.practiz_backend.service.impl;

import com.practiz.practiz_backend.dto.SubCategoryDto;
import com.practiz.practiz_backend.entity.Category;
import com.practiz.practiz_backend.entity.SubCategory;
import com.practiz.practiz_backend.exceptions.ApiException;
import com.practiz.practiz_backend.mapper.SubCategoryMapper;
import com.practiz.practiz_backend.repository.CategoryRepository;
import com.practiz.practiz_backend.repository.SubCategoryRepository;
import com.practiz.practiz_backend.service.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        return subCategoryRepository.findAll()
                .stream()
                .map(SubCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDto createSubCategory(SubCategoryDto subCategoryDto) {
        Category category = categoryRepository.findById(subCategoryDto.getCategoryId())
                .orElseThrow(()-> new ApiException("Category not found with id: "
                        + subCategoryDto.getCategoryId(), HttpStatus.NOT_FOUND));

        SubCategory subCategory = SubCategoryMapper.toEntity(subCategoryDto, category);
        SubCategory saved = subCategoryRepository.save(subCategory);
        return SubCategoryMapper.toDto(saved);
    }

    @Override
    public SubCategoryDto updateSubCategory(Long id, SubCategoryDto subCategoryDto) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(()-> new ApiException("SubCategory not found with id: " + id, HttpStatus.NOT_FOUND));

        Category category = categoryRepository.findById(subCategoryDto.getCategoryId())
                .orElseThrow(()-> new ApiException("Category not found with id: "
                + subCategoryDto.getCategoryId(), HttpStatus.NOT_FOUND));

        subCategory.setName(subCategoryDto.getName());
        subCategory.setCategory(category);

        SubCategory updated = subCategoryRepository.save(subCategory);
        return SubCategoryMapper.toDto(updated);
    }

    @Override
    public void deleteSubCategory(Long id) {
        if(!subCategoryRepository.existsById(id)) {
            throw new ApiException("Subcategory not found with id: "
            + id, HttpStatus.NOT_FOUND);
        }
        subCategoryRepository.deleteById(id);
    }
}
