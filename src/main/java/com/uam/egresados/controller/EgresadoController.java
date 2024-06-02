package com.uam.egresados.controller;

import com.uam.egresados.dto.*;
import com.uam.egresados.error.AlreadyExistsException;
import com.uam.egresados.error.NotSufficientPermissionsException;
import com.uam.egresados.model.Egresado;
import com.uam.egresados.service.IAuthService;
import com.uam.egresados.service.IServiceEgresado;
import com.uam.egresados.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/egresado")
public class EgresadoController {
    private final IServiceEgresado serviceEgresado;
    @Qualifier("ServiceEgresado")
    private final IAuthService<Egresado, EgresadoDTO> authService;
    private final JwtService jwtService;
    private final Logger logger = Logger.getLogger(EgresadoController.class.getName());
    public EgresadoController(IServiceEgresado serviceEgresado, @Qualifier("ServiceEgresado") IAuthService<Egresado, EgresadoDTO> authService, JwtService jwtService) {
        this.serviceEgresado = serviceEgresado;
        this.authService = authService;
        this.jwtService = jwtService;
    }

    Optional<Egresado> isSameUser(String principalName,String id) throws NotSufficientPermissionsException {
        var egresado = serviceEgresado.findByEmail(principalName);

        if (egresado.isPresent() && !egresado.get().getId().equals(id)) {
            throw new NotSufficientPermissionsException("You are not authorized to access that resource");
        }

        return egresado;
    }
    boolean isAdmin() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
    }

    @GetMapping("/all/list")
    ResponseEntity<RequestResponse<List<Egresado>>> getAll() {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceEgresado.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResponse<Optional<Egresado>>> findById(@PathVariable String id) throws NotSufficientPermissionsException {


        if (isAdmin()){
            return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceEgresado.findById(id)));
        }

        var egresado = isSameUser(SecurityContextHolder.getContext().getAuthentication().getName(), id);

        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, egresado));
    }

    @PutMapping("/save")
    public ResponseEntity<RequestResponse<Egresado>> update(@RequestBody @Valid Egresado egresado) throws NotSufficientPermissionsException {
        if (isAdmin()){
            return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceEgresado.save(egresado)));
        }

        isSameUser(SecurityContextHolder.getContext().getAuthentication().getName(), egresado.getId()).get();

        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceEgresado.save(egresado)));
    }

    @PostMapping("/register")
    public ResponseEntity<RequestResponse<Egresado>> register(@RequestBody @Valid EgresadoDTO egresado) throws AlreadyExistsException {

        if (serviceEgresado.findByEmail(egresado.getLogInEmail()).isPresent()) {
            throw new AlreadyExistsException("A user with that email already exists");
        }

        var egresadoObj = serviceEgresado.signUp(egresado);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RequestResponse<>(RequestStatus.success, egresadoObj));
    }
    @PostMapping("/login")
    public ResponseEntity<RequestResponse<LogInResponse>> login(@RequestBody @Valid Access login) {
        Optional<Egresado> egresado;

        egresado = authService.authenticate(login);

        if(egresado.isEmpty()) {
            throw new BadCredentialsException("User doesn't exist");
        }

        var egresadoObj = egresado.get();
        var token = jwtService.generateToken(egresadoObj);
        var response = new RequestResponse<>(RequestStatus.success, new LogInResponse(token, jwtService.getExpirationTime()));

        var headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noStore());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        headers.set("Access-Control-Allow-Headers", "Content-Type, Authorization");
        headers.setCacheControl(CacheControl.noStore());
        headers.setPragma("no-cache");
        headers.set("X-Content-Type-Options", "nosniff");

        return ResponseEntity.ok().headers(headers).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RequestResponse<Egresado>> delete(@PathVariable(name = "id") String id) {
        serviceEgresado.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all/pagination")
    public ResponseEntity<RequestResponse<List<Egresado>>> getAllPagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, serviceEgresado.getAllPagination(pageNo, pageSize, sortBy)));
    }

    @PostMapping("/all/approve")
    public ResponseEntity<RequestResponse<List<String>>> approveAll(@RequestBody @Valid List<String> ids) {
        List<String> successfullIds = new ArrayList<>();

        for (var id : ids) {
            var egresado = serviceEgresado.findById(id);

            if (egresado.isEmpty()) {
                continue;
            }

            var egresadoObj = egresado.get();
            egresadoObj.setAprobado(true);
            serviceEgresado.save(egresadoObj);
            successfullIds.add(id);
        }

        return ResponseEntity.ok(new RequestResponse<>(RequestStatus.success, successfullIds));
    }
}
