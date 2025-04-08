package com.practiz.practiz_backend.mapper;

import com.practiz.practiz_backend.dto.QuestionDto;
import com.practiz.practiz_backend.entity.Question;
import com.practiz.practiz_backend.entity.SubCategory;

public class QuestionMapper {

    public static QuestionDto toDto(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getQuestionText(),
                question.getAnswerText(),
                question.getSubCategory().getId()
        );
    }

    public static Question toEntity(QuestionDto dto, SubCategory subCategory) {
        Question question = new Question();
        question.setId(dto.getId());
        question.setQuestionText(dto.getQuestionText());
        question.setAnswerText(dto.getAnswerText());
        question.setSubCategory(subCategory);
        return question;
    }
}
