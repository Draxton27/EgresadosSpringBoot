package com.uam.egresados.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private String question;
    private QuestionType type;
    private List<String> possible_answers;
    private List<String> answers;
}
