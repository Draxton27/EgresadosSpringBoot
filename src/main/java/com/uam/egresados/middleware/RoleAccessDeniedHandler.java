package com.uam.egresados.middleware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.egresados.dto.ExceptionResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class RoleAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        ExceptionResponse exceptionResponse = new ExceptionResponse("Not sufficent permissions");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(exceptionResponse);

        response.getWriter().write(json);
    }
}
