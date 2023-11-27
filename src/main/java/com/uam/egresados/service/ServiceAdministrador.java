package com.uam.egresados.service;

import com.uam.egresados.model.Administrador;
import com.uam.egresados.repository.IAdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdministrador implements IServiceAdministrador{

 @Autowired
    private IAdministradorRepository repo;

    @Override
    public List<Administrador> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Administrador> findBynombreAdminAndcontrasenia(String nombreAdmin, String contrsenia) {
        return repo.findAdministradorBynombreAdminAndcontrasenia(nombreAdmin,contrsenia);
    }

    @Override
    public Administrador save(Administrador admin) {
        return repo.saveAndFlush(admin);
    }
}
