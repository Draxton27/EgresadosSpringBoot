package com.uam.egresados.configs;

import com.uam.egresados.repository.IAdministradorRepository;
import com.uam.egresados.repository.IEgresadoRepository;
import com.uam.egresados.service.ServiceEgresado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.logging.Logger;

@Configuration
public class UserDetailsServiceConfig {

    private final IEgresadoRepository egresadoRepository;
    private final IAdministradorRepository adminRepository;

    public UserDetailsServiceConfig(IEgresadoRepository egresadoRepository, IAdministradorRepository adminRepository) {
        this.egresadoRepository = egresadoRepository;
        this.adminRepository = adminRepository;
    }

    private static final Logger logger = Logger.getLogger(ServiceEgresado.class.getName());

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            var egresadoOpt = egresadoRepository.findByEmail(username);

            if (egresadoOpt.isPresent()) {
                var egresado = egresadoOpt.get();
                return egresado;
            }

            var adminOpt = adminRepository.findByUsername(username);

            if (adminOpt.isPresent()) {
                var admin = adminOpt.get();
                return admin;
            }

            throw new UsernameNotFoundException("User not found");

        };
    }
}