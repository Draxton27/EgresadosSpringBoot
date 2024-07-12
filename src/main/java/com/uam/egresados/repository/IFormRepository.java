package com.uam.egresados.repository;


import com.uam.egresados.model.Form;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFormRepository extends JpaRepository<Form, String> {
    @Query("select f from Form f where f.name = :name")
    Optional<Form> findByNombre(String name);

    @EntityGraph(attributePaths = {"questions"})
    @Query("SELECT f FROM Form f")
    List<Form> findAllWithQuestions();
}
