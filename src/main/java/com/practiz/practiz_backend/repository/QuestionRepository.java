package com.practiz.practiz_backend.repository;

import com.practiz.practiz_backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySubCategoryId(Long subCategoryId);
}
