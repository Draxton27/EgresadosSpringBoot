package com.uam.egresados.dto;

import com.uam.egresados.model.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {

    @NotBlank(message = "Question can't be empty")
    @NotEmpty
    @NotNull
    private String question;

    @NotEmpty(message = "QuestionType Has to be Set")
    @NotNull
    private QuestionType type;

    private List<String> possibleAnswers;

    private List<String> answers;

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "question='" + question + '\'' +
                ", type=" + type +
                ", possibleAnswers=" + possibleAnswers +
                ", answers=" + answers +
                '}';
    }
}
