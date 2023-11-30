package com.uam.egresados.controller;

import com.uam.egresados.model.Access;
import com.uam.egresados.model.Egresado;
import com.uam.egresados.service.IServiceEgresado;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.uam.egresados.WebConfig.REACT_URL;

@RestController
@RequestMapping("/egresado")
public class EgresadoController {

    @Autowired
    private IServiceEgresado serviceEgresado;


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

    @PostMapping("/login")
    public String login(@RequestBody Access login) {
        var egresado = serviceEgresado.findByCorreosAndPassword(login.getEmail(), login.getPassword());

        if (egresado.isEmpty()) {
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

    @PostMapping("/approveAll")
    public void approveAll(@RequestBody List<String> ids) {

        for(var id : ids) {
            var egresado = serviceEgresado.findById(id);

            if(egresado.isEmpty()) {
                continue;
            }



            var egresadoObj = egresado.get();
            egresadoObj.setAprobado(true);
            serviceEgresado.save(egresadoObj);
        }
    }

}
