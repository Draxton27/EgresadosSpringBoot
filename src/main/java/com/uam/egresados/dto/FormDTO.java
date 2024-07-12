package com.uam.egresados.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormDTO {

    //@JsonProperty means that when serializing it to JSON
    //it takes into account
    //This makes it so that it can only be access on WRITE
    //@JsonProperty(access = JsonProperty.Acess.WRITE_ONLY)
    @NotBlank
    @NotNull
    private String name;

    private String description;

    @NotNull
    private List<QuestionDTO> questions;

    private boolean published;
}
