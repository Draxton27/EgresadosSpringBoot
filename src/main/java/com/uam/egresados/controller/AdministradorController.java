package com.uam.egresados.controller;

import com.uam.egresados.model.Access;
import com.uam.egresados.model.Administrador;
import java.util.List;
import com.uam.egresados.service.IServiceAdministrador;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private IServiceAdministrador serviceAdministrador;

    @GetMapping("/all")
    public List<Administrador> getAll() {
        return serviceAdministrador.getAll();
    }


    @PostMapping("/login")
    public String login (@RequestBody Access login, HttpServletResponse response){
        var admin = serviceAdministrador.findBynombreAdminAndcontrasenia(login.getEmail(), login.getPassword());

        if(admin.isEmpty()) {
            return "";
        }

        return "Acceso permitido";
    }

    @PostMapping("/save")
    public Administrador insert(@RequestBody Administrador admin) {
        return serviceAdministrador.save(admin);
    }

    @PutMapping("/save")
    public Administrador update(@RequestBody Administrador admin) {
        return serviceAdministrador.save(admin);
    }

}
