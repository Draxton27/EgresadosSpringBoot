package com.uam.egresados.controller;

import com.uam.egresados.dto.Access;
import com.uam.egresados.dto.LogInResponse;
import com.uam.egresados.dto.RequestResponse;
import com.uam.egresados.dto.RequestStatus;
import com.uam.egresados.model.Administrador;
import com.uam.egresados.service.IAuthService;
import com.uam.egresados.service.IServiceAdministrador;
import com.uam.egresados.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private final IServiceAdministrador serviceAdministrador;
    private final IAuthService<Administrador, Access> authService;
    private final JwtService jwtService;

    public AdministradorController(IServiceAdministrador serviceAdministrador, IAuthService<Administrador, Access> authService, JwtService jwtService) {
        this.serviceAdministrador = serviceAdministrador;
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @GetMapping("/all")
    public ResponseEntity<RequestResponse<List<Administrador>>> getAll() {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceAdministrador.getAll()));
    }

    @PostMapping("/login")
    public ResponseEntity<RequestResponse<LogInResponse>> login(@RequestBody @Valid Access login){


        Optional<Administrador> administrador;

        administrador = authService.authenticate(login);

        if(administrador.isEmpty()){
            throw new BadCredentialsException("User doesn't exist");
        }

        var headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noStore());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        headers.set("Access-Control-Allow-Headers", "Content-Type, Authorization");
        headers.setCacheControl(CacheControl.noStore());
        headers.setPragma("no-cache");
        headers.set("X-Content-Type-Options", "nosniff");

        var administradorObj = administrador.get();
        var token = jwtService.generateToken(administradorObj);
        var response = new RequestResponse<>(RequestStatus.success, new LogInResponse(token, jwtService.getExpirationTime()));
        //add the headers to the response
        return ResponseEntity.ok().headers(headers).body(response);
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
