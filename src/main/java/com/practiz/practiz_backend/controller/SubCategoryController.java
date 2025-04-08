package com.practiz.practiz_backend.controller;

import com.practiz.practiz_backend.dto.SubCategoryDto;
import com.practiz.practiz_backend.service.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategories")
@CrossOrigin("*")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<SubCategoryDto>> getAllSubCategories() {
        return ResponseEntity.ok(subCategoryService.getAllSubCategories());
    }

    @PostMapping
    public ResponseEntity<SubCategoryDto> createSubCategory(@RequestBody SubCategoryDto subCategoryDto) {
        SubCategoryDto created = subCategoryService.createSubCategory(subCategoryDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(@PathVariable Long id, @RequestBody SubCategoryDto subCategoryDto) {
        SubCategoryDto updated = subCategoryService.updateSubCategory(id, subCategoryDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
    subCategoryService.deleteSubCategory(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
