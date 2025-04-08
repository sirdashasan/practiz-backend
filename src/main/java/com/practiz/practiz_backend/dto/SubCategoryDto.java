package com.practiz.practiz_backend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDto {
    private Long id;
    private String name;
    private Long categoryId;
}
