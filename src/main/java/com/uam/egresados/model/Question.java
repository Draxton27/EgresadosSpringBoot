package com.uam.egresados.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private String question;
    private QuestionType type;
    private ArrayList<String> answers;
}
