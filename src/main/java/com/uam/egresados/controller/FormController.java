package com.uam.egresados.controller;

import com.uam.egresados.model.Egresado;
import com.uam.egresados.model.Form;
import com.uam.egresados.service.IServiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private IServiceForm serviceForm;


    @GetMapping("/all")
    List<Form> getAll() {
        return serviceForm.getAll();
    }


    @GetMapping("/getById")
    public Optional<Form> findById(@RequestParam(name = "id") String id) {
        return serviceForm.findById(id);
    }
    @PostMapping("/save")
    public Form insert(@RequestBody Form form) {
        return serviceForm.save(form);
    }

    @PutMapping("/save")
    public Form update(@RequestBody Form form) {
        return serviceForm.save(form);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        serviceForm.delete(id);
    }

}
