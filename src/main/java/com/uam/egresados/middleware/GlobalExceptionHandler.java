package com.uam.egresados.middleware;

import com.uam.egresados.dto.ExceptionResponse;
import com.uam.egresados.error.AlreadyExistsException;
import com.uam.egresados.error.NotSufficientPermissionsException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleAlreadyExistsException(AlreadyExistsException e) {
        logger.severe("Got AlreadyExistsException: " + e.getMessage());
        var responseBody = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            var fieldName = ((FieldError)error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.add(String.format("%s: %s", fieldName, errorMessage));
        });

        String joinedErrors = String.join(", ", errors);

        logger.severe("Got MethodArgumentNotValidException: " + joinedErrors);
        var responseBody = new ExceptionResponse(joinedErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleBadCredentialsException(BadCredentialsException e) {
        logger.severe("Got BadCredentialsException: " + e.getMessage());
        var responseBody = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException e) {
        logger.severe("Got AccessDeniedException: " + e.getMessage());
        var responseBody = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<ExceptionResponse> handleInsufficientAuthenticationException(InsufficientAuthenticationException e) {
        logger.severe("Got InsufficientAuthenticationException: " + e.getMessage());
        var responseBody = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ExceptionResponse> handleMalformedJwtException(MalformedJwtException e) {
        logger.severe("Got MalformedJwtException: " + e.getMessage());
        var responseBody = new ExceptionResponse("Invalid auth");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ExceptionResponse> handleExpiredJwtException(ExpiredJwtException e) {
        logger.severe("Got ExpiredJwtException: " + e.getMessage());
        var responseBody = new ExceptionResponse("Invalid auth");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
    @ExceptionHandler(NotSufficientPermissionsException.class)
    public ResponseEntity<ExceptionResponse> handleNotSufficientPermissionsException(NotSufficientPermissionsException e) {
        logger.severe("Got NotSufficientPermissionsException: " + e.getMessage());
        var responseBody = new ExceptionResponse("Invalid auth");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseBody);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        logger.severe("Got " + e.getClass().getCanonicalName() + e.getMessage());
        var responseBody = new ExceptionResponse(e.getMessage());
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

}