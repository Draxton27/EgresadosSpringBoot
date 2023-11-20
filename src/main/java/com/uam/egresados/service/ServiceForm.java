package com.uam.egresados.service;

import com.uam.egresados.model.Form;
import com.uam.egresados.repository.IFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceForm implements IServiceForm{

    @Autowired
    IFormRepository repo;

    @Override
    public List<Form> getAll() {
        return repo.findAll();
    }

    @Override
    public Form save(Form form) {
        return repo.saveAndFlush(form);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Form> findById(String id) {
        return repo.findById(id);
    }
}
