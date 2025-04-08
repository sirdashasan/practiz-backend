package com.practiz.practiz_backend.service;

import com.practiz.practiz_backend.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestions();
    List<QuestionDto> getQuestionsBySubCategoryId(Long subCategoryId);
    QuestionDto createQuestion(QuestionDto questionDto);
    QuestionDto updateQuestion(Long id, QuestionDto questionDto);
    void deleteQuestion(Long id);

}
