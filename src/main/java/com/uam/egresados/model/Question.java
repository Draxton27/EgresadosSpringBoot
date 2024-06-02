package com.uam.egresados.model;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Question can't be empty")
    @NotEmpty
    @NotNull
    private String question;

    @NotEmpty(message = "QuestionType Has to be Set")
    @NotNull
    private QuestionType type;

    private List<String> possible_answers;
    private List<String> answers;
}
