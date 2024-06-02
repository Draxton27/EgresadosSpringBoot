package com.uam.egresados.service;

import com.uam.egresados.dto.Access;
import com.uam.egresados.model.Administrador;
import com.uam.egresados.repository.IAdministradorRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdministrador implements IServiceAdministrador, IAuthService<Administrador, Access> {

    private final IAdministradorRepository repo;
    private final AuthenticationManager authenticationManager;

    public ServiceAdministrador(IAdministradorRepository repo, AuthenticationManager authenticationManager) {
        this.repo = repo;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public List<Administrador> getAll() {
        return repo.findAll();
    }

    @Override
    public Administrador save(Administrador administrador) {
        return repo.save(administrador);
    }

    @Override
    public Optional<Administrador> authenticate(Access login) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getEmail(),
                        login.getPassword()
                )
        );

        return repo.findByUsername(login.getEmail());
    }
}
