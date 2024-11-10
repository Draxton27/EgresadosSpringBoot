package com.uam.egresados.repository;

import com.uam.egresados.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, String> {
}