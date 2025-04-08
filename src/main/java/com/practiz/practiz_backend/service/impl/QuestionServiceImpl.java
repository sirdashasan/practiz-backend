package com.practiz.practiz_backend.service.impl;

import com.practiz.practiz_backend.dto.QuestionDto;
import com.practiz.practiz_backend.entity.Question;
import com.practiz.practiz_backend.entity.SubCategory;
import com.practiz.practiz_backend.exceptions.ApiException;
import com.practiz.practiz_backend.mapper.QuestionMapper;
import com.practiz.practiz_backend.repository.QuestionRepository;
import com.practiz.practiz_backend.repository.SubCategoryRepository;
import com.practiz.practiz_backend.service.QuestionService;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final SubCategoryRepository subCategoryRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, SubCategoryRepository subCategoryRepository) {
        this.questionRepository = questionRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public QuestionServiceImpl() {
        super();
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(QuestionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionDto> getQuestionsBySubCategoryId(Long subCategoryId) {
        return questionRepository.findBySubCategoryId(subCategoryId).stream()
                .map(QuestionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        SubCategory subCategory = subCategoryRepository.findById(questionDto.getSubCategoryId())
                .orElseThrow(()-> new ApiException("SubCategory not found with id: "
                + questionDto.getSubCategoryId(), HttpStatus.NOT_FOUND));

        Question question = QuestionMapper.toEntity(questionDto, subCategory);
        Question saved = questionRepository.save(question);
        return QuestionMapper.toDto(saved);
    }

    @Override
    public QuestionDto updateQuestion(Long id, QuestionDto questionDto) {
        Question question = questionRepository.findById(id)
                .orElseThrow(()-> new ApiException("Question not found with id: " + id, HttpStatus.NOT_FOUND));

        SubCategory subCategory = subCategoryRepository.findById(questionDto.getSubCategoryId())
                .orElseThrow(()-> new ApiException("SubCategory not found with id: "
                +questionDto.getSubCategoryId(), HttpStatus.NOT_FOUND));

        question.setQuestionText(questionDto.getQuestionText());
        question.setAnswerText(questionDto.getAnswerText());
        question.setSubCategory(subCategory);

        Question updated = questionRepository.save(question);
        return QuestionMapper.toDto(updated);
    }

    @Override
    public void deleteQuestion(Long id) {
        if(!questionRepository.existsById(id)) {
            throw new ApiException("Question not found with id: " + id, HttpStatus.NOT_FOUND);
        }

        questionRepository.deleteById(id);
    }
}
