package com.uam.egresados.controller;

import com.uam.egresados.model.Egresado;
import com.uam.egresados.service.IServiceEgresado;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public Egresado insert(@RequestBody Egresado egresado) {
        return serviceEgresado.save(egresado);
    }

    @PutMapping("/save")
    public Egresado update(@RequestBody Egresado egresado) {
        return serviceEgresado.save(egresado);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        serviceEgresado.delete(id);
    }

    @GetMapping("/allPagination")
    public List<Egresado> getAllPagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        return serviceEgresado.getAllPagination(pageNo, pageSize, sortBy);
    }
}
