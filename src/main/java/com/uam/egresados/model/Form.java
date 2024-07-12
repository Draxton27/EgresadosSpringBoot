package com.uam.egresados.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Form extends Identity {
    //@JsonProperty means that when serializing it to JSON
    //it takes into account
    //This makes it so that it can only be access on WRITE
    //@JsonProperty(access = JsonProperty.Acess.WRITE_ONLY)
    @NotBlank
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    @NotNull
    @ToString.Exclude
    private List<Question> questions;

    @ElementCollection
    private Set<String> answersCollectedFrom;

    private String description;

    private boolean published;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Form form = (Form) o;
        return getId() != null && Objects.equals(getId(), form.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
