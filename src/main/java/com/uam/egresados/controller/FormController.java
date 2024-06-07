package com.uam.egresados.controller;

import com.uam.egresados.dto.FormDTO;
import com.uam.egresados.dto.RequestResponse;
import com.uam.egresados.dto.RequestStatus;
import com.uam.egresados.error.AlreadyExistsException;
import com.uam.egresados.error.InternalServerErrorException;
import com.uam.egresados.model.Form;
import com.uam.egresados.model.Question;
import com.uam.egresados.repository.IQuestionRepository;
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

import java.util.*;

import static com.uam.egresados.configs.WebConfig.REACT_URL;

@RestController
@RequestMapping("/form")
public class FormController {
    private final IServiceForm serviceForm;

    private final JavaMailSender mailSender;

    private final IServiceEgresado serviceEgresado;

    private  final IQuestionRepository questionRepository;

    public FormController(IServiceForm serviceForm, JavaMailSender mailSender, IServiceEgresado serviceEgresado, IQuestionRepository questionRepository) {
        this.serviceForm = serviceForm;
        this.mailSender = mailSender;
        this.serviceEgresado = serviceEgresado;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/all")
    ResponseEntity<RequestResponse<List<Form>>> getAll() {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceForm.getAll()));
    }

    @PostMapping("/all/approve")
    ResponseEntity<RequestResponse<List<String>>> approveAll(@RequestBody @Valid List<String> ids) {
        List<String> successfullIds = new ArrayList<>();

        for (var id : ids) {
            var form = serviceForm.findById(id);

            if (form.isEmpty()) {
                continue;
            }

            var formObj = form.get();
            formObj.setPublished(true);

            //sendForm(formObj);
            serviceForm.save(formObj);
            successfullIds.add(id);
        }

        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, successfullIds));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResponse<Optional<Form>>> findById(@PathVariable String id) {

        var formOpt = serviceForm.findById(id);

        if (formOpt.isEmpty()) {
            return new ResponseEntity<>(new RequestResponse<>(RequestStatus.success, null), HttpStatus.NOT_FOUND);
        }

        var form = formOpt.get();

        for (var question : form.getQuestions()) {
            for(var answer : question.getAnswers()) {
                var egresado= serviceEgresado.findById(answer.getAnsweredById());

                if (egresado.isPresent()) {
                    answer.setAnsweredByName(egresado.get().getNombreCompleto());
                }else {
                    answer.setAnsweredByName("Unknown");
                }
            }
        }

        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceForm.findById(id)));
    }

    private void sendForm(Form f) throws InternalServerErrorException {
        for (var egresado : serviceEgresado.getAll()) {
            var message = new SimpleMailMessage();

            message.setTo(egresado.getLogInEmail());
            message.setSubject("Nueva encuesta de Egresados UAM - " + f.getName());
            message.setText("Contesta la entrando al siguiente link:\n" + REACT_URL + "/form_answer/" + f.getId());

            try {
                mailSender.send(message);
            } catch (MailException ex) {
                throw new InternalServerErrorException(ex.getMessage());
            }
        }
    }

    @PostMapping("/save")
    public ResponseEntity<RequestResponse<Form>> insert(@RequestBody @Valid FormDTO formDTO) throws AlreadyExistsException, InternalServerErrorException {
        if (serviceForm.findByName(formDTO.getName()).isPresent()) {
            throw new AlreadyExistsException("A form with that name already exists");
        }

        var form = new Form();
        form.setName(formDTO.getName());
        form.setDescription(formDTO.getDescription());

        var questionObjArray = new ArrayList<Question>();
        for (var question : formDTO.getQuestions()) {
            var questionObj = new Question();
            questionObj.setQuestion(question.getQuestion());
            questionObj.setType(question.getType());
            questionObj.setPossibleAnswers(question.getPossibleAnswers());
            //questionObj.setAnswers(new ArrayList<>());
            questionObj.setAnswers(question.getAnswers());
            questionObj = questionRepository.save(questionObj);
            questionObjArray.add(questionObj);
        }

        form.setQuestions(questionObjArray);
        form.setAnswersCollectedFrom(new HashSet<>());
        var newForm = serviceForm.save(form);

        var response = ResponseEntity.status(HttpStatus.CREATED).body(new RequestResponse<>(RequestStatus.success, newForm));

        if(!formDTO.isPublished()) {
            return response;
        }

        sendForm(newForm);
        return response;
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
