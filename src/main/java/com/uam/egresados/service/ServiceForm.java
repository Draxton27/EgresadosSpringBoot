package com.uam.egresados.service;

import com.uam.egresados.model.Form;
import com.uam.egresados.repository.IFormRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceForm implements IServiceForm {
    
    private final IFormRepository repo;

    public ServiceForm(IFormRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Form> getAll() {
        return repo.findAllWithQuestions();
    }

    @Override
    @Transactional
    public Form save(Form form) {
        return repo.saveAndFlush(form);
    }

    @Override
    @Transactional
    public void delete(String id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Form> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Form> findByName(String name) {
        return repo.findByNombre(name);
    }
}