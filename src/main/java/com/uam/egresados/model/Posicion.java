package com.uam.egresados.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Before;

import java.time.LocalDate;
import java.util.Optional;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posicion {
    @NotBlank
    @NotEmpty
    @NotNull
    private String posicionActual;

    @PastOrPresent
    private LocalDate fechaInicio;

    @PastOrPresent
    private LocalDate fechaTerminacion;
}
