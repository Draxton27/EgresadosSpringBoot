package com.uam.egresados.controller;

import com.uam.egresados.model.Access;
import com.uam.egresados.model.Egresado;
import com.uam.egresados.repository.IEgresadoRepository;
import com.uam.egresados.service.IServiceEgresado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/egresado")
public class EgresadoController {

    @Autowired
    private IServiceEgresado serviceEgresado;
    @Autowired
    private IEgresadoRepository iEgresadoRepository;

    @GetMapping("/all")
    List<Egresado> getAll() {
        return serviceEgresado.getAll();
    }

    @GetMapping("/getByName")
    public List<Egresado> findByNombre(@RequestParam(name = "primerNombre") String nombre) {
        return serviceEgresado.findByPrimerNombre(nombre);
    }

    @GetMapping("/getById")
    public Optional<Egresado> findById(@RequestParam(name = "id") String id) {
        return serviceEgresado.findById(id);
    }
    @PostMapping("/save")
    public Egresado insert(@RequestBody Egresado egresado) {
        return serviceEgresado.save(egresado);
    }

    @PutMapping("/save")
    public Egresado update(@RequestBody Egresado egresado) {

        return serviceEgresado.save(egresado);
    }

    @GetMapping("/login")
    public String login (@RequestBody Access login){
        var egresado = serviceEgresado.findByCorreosAndPassword(login.getEmail(), login.getPassword());

        if(egresado.isEmpty()) {
            return "";
        }

        return egresado.get().getId();
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
