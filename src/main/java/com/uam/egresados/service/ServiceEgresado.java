package com.uam.egresados.service;

import com.uam.egresados.dto.Access;
import com.uam.egresados.dto.EgresadoDTO;
import com.uam.egresados.model.Egresado;
import com.uam.egresados.repository.IEgresadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service("ServiceEgresado")
public class ServiceEgresado implements IServiceEgresado, IAuthService<Egresado, EgresadoDTO> {
    private final IEgresadoRepository repo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public ServiceEgresado(IEgresadoRepository repo, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

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
    public Optional<Egresado> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Optional<Egresado> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Egresado signUp(EgresadoDTO egresado) {

        var egresadoEntity = new Egresado();
        egresadoEntity.setPrimerNombre(egresado.getPrimerNombre());
        egresadoEntity.setSegundoNombre(egresado.getSegundoNombre());
        egresadoEntity.setPrimerApellido(egresado.getPrimerApellido());
        egresadoEntity.setSegundoApellido(egresado.getSegundoApellido());
        egresadoEntity.setFechaNacimiento(egresado.getFechaNacimiento());
        egresadoEntity.setLogInEmail(egresado.getLogInEmail());
        egresadoEntity.setPassword(passwordEncoder.encode(egresado.getPassword()));
        egresadoEntity.setCif(egresado.getCif());
        egresadoEntity.setFechaGraduacion(egresado.getFechaGraduacion());
        egresadoEntity.setCargoActual(egresado.getCargoActual());
        egresadoEntity.setContactos(egresado.getContactos());
        egresadoEntity.setCorreos(egresado.getCorreos());
        egresadoEntity.setTrabajos(egresado.getTrabajos());
        egresadoEntity.setCarreras(egresado.getCarreras());
        egresadoEntity.setEtnia(egresado.getEtnia());
        egresadoEntity.setAprobado(true);

        return repo.saveAndFlush(egresadoEntity);
    }

    @Override
    public List<Egresado> getAllPagination(Integer pageNo, Integer pageSize, String sortBy) {
        var pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        var pagedResult = repo.findAll(pageable);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    private static final Logger logger = Logger.getLogger(ServiceEgresado.class.getName());
    @Override
    public Optional<Egresado> authenticate(Access login) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getEmail(),
                        login.getPassword()
                )
        );

        return repo.findByEmail(login.getEmail());
    }
}
