package com.ifto.reservas.controller.errors;

public class ReservasNotFoundExeption extends  RuntimeException{
    public ReservasNotFoundExeption(Long id) {
        super("Reserva de ID "+id+ " não encontrada.");
    }


}
