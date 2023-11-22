package com.uam.egresados.service;

import com.uam.egresados.model.Egresado;
import com.uam.egresados.repository.IEgresadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEgresado implements IServiceEgresado{
    @Autowired
    private IEgresadoRepository repo;

    @Override
    public List<Egresado> getAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public Egresado save(Egresado egresado) {
        return repo.saveAndFlush(egresado);
    }

    @Override
    @Transactional
    public void delete(String id) {
        repo.deleteById(id);
    }

    @Override
    public List<Egresado> findByPrimerNombre(String nombre) {
        return repo.findEgresadoByPrimerNombre(nombre);
    }

    @Override
    public List<Egresado> findByCorreosAndPassword(String email, String password) {
        return repo.findEgresadoByCorreosAndPassword(email,password);
    }

    @Override
    public Optional<Egresado> findById(String id) {
        return repo.findById(id);
    }
    @Override
    public List<Egresado> getAllPagination(Integer pageNo, Integer pageSize, String sortBy) {
        var pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        var pagedResult = repo.findAll(pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Egresado>();
        }
    }
}
