package com.ifto.reservas.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EspacoNotFoundAdvice {
    @ExceptionHandler(EspacoNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String espacoNotFoundHandler(EspacoNotFoundExeption ex) {
        return ex.getMessage();
    }

}
