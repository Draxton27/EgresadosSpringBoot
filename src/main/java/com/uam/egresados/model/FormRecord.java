package com.uam.egresados.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "Record_Encuesta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FormRecord extends Identity{
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "egresado_id", nullable = false)
    private Egresado egresado;
    --- Relación inexistente en las respuestas por las preguntas por egresados --- 
    */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", nullable = false)
    @NotNull
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @NotNull
    private Question question;

    @Column(nullable = false)
    private String answer;

    // private LocalDate responseDate; Fecha de proporcionada la encuesta, a fin de tener un historial cronológico (agregar en entidad Question) idkkkk

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || HibernateProxy.class.isAssignableFrom(o.getClass())) return false;
        FormRecord that = (FormRecord) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}