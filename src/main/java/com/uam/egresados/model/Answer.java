package com.uam.egresados.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Answer {
    @NotNull
    @NotBlank
    private String text;

    @NotNull
    @NotBlank
    private String answeredById;

    private transient String answeredByName;
}
