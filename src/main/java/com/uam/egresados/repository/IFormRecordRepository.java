package com.uam.egresados.repository;

import com.uam.egresados.model.FormRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFormRecordRepository extends JpaRepository<FormRecord, String> {
    @Query("select f from FormRecord f where f.form.name = :name")
    Optional<FormRecord> findByNombre(String name);
}