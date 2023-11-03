package com.uam.egresados.controller;

import com.uam.egresados.model.Egresado;
import com.uam.egresados.service.IServiceEgresado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/egresado")
public class EgresadoController {
    private IServiceEgresado serviceEgresado;

    @GetMapping("/all")
    List<Egresado> getAll() {
        return serviceEgresado.getAll();
    }

    @GetMapping("/findByNombre")
    public List<Egresado> findByNombre(@RequestParam(name = "nombre") String nombre) {
        return serviceEgresado.findByNombre(nombre);
    }
}
