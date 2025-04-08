package com.practiz.practiz_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long id;
    private String questionText;
    private String answerText;
    private Long subCategoryId;
}
