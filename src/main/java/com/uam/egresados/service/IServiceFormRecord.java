package com.uam.egresados.service;

import com.uam.egresados.model.FormRecord;

import java.util.List;
import java.util.Optional;

public interface IServiceFormRecord {
    List<FormRecord> getAll();

    Optional<FormRecord> findById(String id);

    Optional<FormRecord> findByName(String name);
}