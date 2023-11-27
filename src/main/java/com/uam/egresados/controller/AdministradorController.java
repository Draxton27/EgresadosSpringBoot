package com.uam.egresados.controller;

import com.uam.egresados.model.Access;
import com.uam.egresados.model.Administrador;
import com.uam.egresados.model.Egresado;
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

    @GetMapping("/login")
    public String login (@RequestBody Access login, HttpServletResponse response){
        var admin = serviceAdministrador.findBynombreAdminAndcontrasenia(login.getEmail(), login.getPassword());

        if(admin.isEmpty()) {
            return "Acceso denegado";
        }
        var cookie = new Cookie("id", admin.get().getId());
        response.addCookie(cookie);

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
