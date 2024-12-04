package com.uam.egresados.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Publicidad")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Advertisement extends Identity{

    @Column(nullable = true, length = 10000)
    private String Content;

    @Column(nullable = false)
    private String mediaUrl;

    @Column(nullable = false)
    private Format format; // Tipo de formato: TEXT, IMAGE, BANNER

    @ElementCollection(targetClass = Placement.class)
    @Enumerated(EnumType.STRING) // Almacena los nombres de los enums como texto
    @CollectionTable(name = "Ubicacion_Publicidad", joinColumns = @JoinColumn(name = "id_publicidad"))
    @Column(name = "ubicacion")
    private List<Placement> placement; // Ubicación (puede ser una o varias): DASHBOARD, HOMEPAGE...

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private Boolean isVisible = true;
    // Upper three variables may or may not stay

    public enum Format {
        IMAGE, BANNER, TEXT
    }

    public enum Placement {
        HOMEPAGE, DASHBOARD
    }
}