package com.ifto.reservas.controller.errors;

public class ResponsavelNotFoundExeption extends  RuntimeException{
    public ResponsavelNotFoundExeption(Long id) {
        super("Responsavel de ID "+id+ " não encontrado.");
    }


}
