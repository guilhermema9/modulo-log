package com.ifto.reservas.controller.errors;

public class EspacoNotFoundExeption extends  RuntimeException{
    public EspacoNotFoundExeption(Long id) {
        super("Espaço de ID "+id+ " não encontrado.");
    }


}
