package com.uam.egresados.configs;

import com.uam.egresados.repository.IAdministradorRepository;
import com.uam.egresados.repository.IEgresadoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailsServiceConfig {

    private final IEgresadoRepository egresadoRepository;
    private final IAdministradorRepository adminRepository;

    public UserDetailsServiceConfig(IEgresadoRepository egresadoRepository, IAdministradorRepository adminRepository) {
        this.egresadoRepository = egresadoRepository;
        this.adminRepository = adminRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            var egresadoOpt = egresadoRepository.findByEmail(username);

            if (egresadoOpt.isPresent()) {
                return egresadoOpt.get();
            }

            var adminOpt = adminRepository.findByUsername(username);

            if (adminOpt.isPresent()) {
                return adminOpt.get();
            }

            throw new UsernameNotFoundException("User not found");

        };
    }
}