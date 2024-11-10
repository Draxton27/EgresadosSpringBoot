package com.uam.egresados.service;

import com.uam.egresados.model.FormRecord;
import com.uam.egresados.repository.IFormRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceFormRecord implements IServiceFormRecord {

    @Autowired
    private IFormRecordRepository formRecordRepository;

    @Override
    public List<FormRecord> getAll() {
        return formRecordRepository.findAll();
    }

    @Override
    public Optional<FormRecord> findById(String id) {
        return formRecordRepository.findById(id);
    }

    @Override
    public Optional<FormRecord> findByName(String name) {
        return formRecordRepository.findByNombre(name);
    }
}