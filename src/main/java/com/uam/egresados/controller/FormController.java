package com.uam.egresados.controller;

import com.uam.egresados.model.Egresado;
import com.uam.egresados.model.Form;
import com.uam.egresados.service.IServiceEgresado;
import com.uam.egresados.service.IServiceForm;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.uam.egresados.WebConfig.REACT_URL;

@RestController
@RequestMapping("/form")
public class FormController {
    @Autowired
    private IServiceForm serviceForm;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private IServiceEgresado serviceEgresado;

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
        var newForm = serviceForm.save(form);

        for(var egresado : serviceEgresado.getAll()) {
            var message = new SimpleMailMessage();

            message.setTo(egresado.getLogInEmail());
            message.setSubject("Nueva encuesta de Egresados UAM - " + newForm.getName());
            message.setText("Contesta la entrando al siguiente link:\n" + REACT_URL + "/form_answer/" + newForm.getId());
            mailSender.send(message);
        }

        return newForm;
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
