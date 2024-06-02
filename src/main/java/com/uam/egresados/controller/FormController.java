package com.uam.egresados.controller;

import com.uam.egresados.dto.FormDTO;
import com.uam.egresados.dto.RequestResponse;
import com.uam.egresados.dto.RequestStatus;
import com.uam.egresados.error.AlreadyExistsException;
import com.uam.egresados.error.InternalServerErrorException;
import com.uam.egresados.model.Form;
import com.uam.egresados.service.IServiceEgresado;
import com.uam.egresados.service.IServiceForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.uam.egresados.configs.WebConfig.REACT_URL;

@RestController
@RequestMapping("/form")
public class FormController {
    private final IServiceForm serviceForm;

    private final JavaMailSender mailSender;

    private final IServiceEgresado serviceEgresado;

    public FormController(IServiceForm serviceForm, JavaMailSender mailSender, IServiceEgresado serviceEgresado) {
        this.serviceForm = serviceForm;
        this.mailSender = mailSender;
        this.serviceEgresado = serviceEgresado;
    }

    @GetMapping("/all")
    ResponseEntity<RequestResponse<List<Form>>> getAll() {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceForm.getAll()));
    }

    @GetMapping("/getById")
    public ResponseEntity<RequestResponse<Optional<Form>>> findById(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceForm.findById(id)));
    }

    @PostMapping("/save")
    public ResponseEntity<RequestResponse<Form>> insert(@RequestBody @Valid FormDTO formDTO) throws AlreadyExistsException, InternalServerErrorException {

        if (serviceForm.findByName(formDTO.getName()).isPresent()) {
            throw new AlreadyExistsException("A form with that name already exists");
        }

        var form = new Form();
        form.setName(formDTO.getName());
        form.setQuestions(formDTO.getQuestions());
        form.setAnswersCollectedFrom(formDTO.getAnswersCollectedFrom());

        var newForm = serviceForm.save(form);

        for (var egresado : serviceEgresado.getAll()) {
            var message = new SimpleMailMessage();

            message.setTo(egresado.getLogInEmail());
            message.setSubject("Nueva encuesta de Egresados UAM - " + newForm.getName());
            message.setText("Contesta la entrando al siguiente link:\n" + REACT_URL + "/form_answer/" + newForm.getId());

            try {
                mailSender.send(message);
            } catch (MailException ex) {
                throw new InternalServerErrorException(ex.getMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new RequestResponse<>(RequestStatus.success, newForm));
    }

    @PutMapping("/save")
    public ResponseEntity<RequestResponse<Form>> update(@RequestBody @Valid Form form) {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceForm.save(form)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RequestResponse<Form>> delete(@PathVariable(name = "id") String id) {
        serviceForm.delete(id);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> beanValidationExceptionHandler(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            var fieldName = ((FieldError)error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });

        return errors;
    }

}
