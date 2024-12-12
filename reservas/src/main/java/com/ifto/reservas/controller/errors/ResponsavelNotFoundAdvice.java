package com.ifto.reservas.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponsavelNotFoundAdvice {
    @ExceptionHandler(ResponsavelNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String responsavelNotFoundHandler(ResponsavelNotFoundExeption ex) {
        return ex.getMessage();
    }

}
