package com.uam.egresados.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Encuestas")
public class Form extends Identity {

    //@JsonProperty means that when serializing it to JSON
    //it takes into account
    //This makes it so that it can only be access on WRITE
    //@JsonProperty(access = JsonProperty.Acess.WRITE_ONLY)
    @NotBlank
    @NotNull
    @NotEmpty
    private String name;

    @ElementCollection
    @NotEmpty
    @NotNull
    private List<Question> questions;

    @ElementCollection
    private Set<String> answersCollectedFrom;
}
