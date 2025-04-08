package com.practiz.practiz_backend.service;

import com.practiz.practiz_backend.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {
    List<SubCategoryDto> getAllSubCategories();
    SubCategoryDto createSubCategory(SubCategoryDto subCategoryDto);
    SubCategoryDto updateSubCategory(Long id, SubCategoryDto subCategoryDto);
    void deleteSubCategory(Long id);
}
