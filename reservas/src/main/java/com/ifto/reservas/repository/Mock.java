package com.ifto.reservas.repository;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.Reserva;
import com.ifto.reservas.model.Responsavel;
import com.ifto.reservas.model.enums.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Mock {

    public static List<EspacoFisico> getEspacosFisicos() {

        return Arrays.asList(
                new EspacoFisico(1L, "Sala 101", "Sala de aula com 30 lugares", TipoEspaco.SALA_DE_AULA, 30, "[\"Projetor\", \"Ar Condicionado\"]", LocalDateTime.of(2023, 1, 1, 10, 0), LocalDateTime.of(2023, 1, 1, 10, 0), SituacaoEspaco.ATIVO, "Bloco A", "Nenhuma"),
                new EspacoFisico(2L, "Auditório Principal", "Auditório com capacidade para 200 pessoas", TipoEspaco.AUDITORIO, 200, "[\"Sistema de Som\", \"Microfone\"]", LocalDateTime.of(2023, 1, 1, 10, 0), LocalDateTime.of(2023, 1, 1, 10, 0), SituacaoEspaco.ATIVO, "Bloco B", "Nenhuma"),
                new EspacoFisico(3L, "Laboratório de Informática", "Laboratório com 20 computadores", TipoEspaco.LABORATORIO, 20, "[\"Computadores\", \"Projetor\"]", LocalDateTime.of(2023, 1, 1, 10, 0), LocalDateTime.of(2023, 1, 1, 10, 0), SituacaoEspaco.MANUTENCAO, "Bloco C", "Nenhuma")
        );
    }


    public static List<Responsavel> getResponsaveis() {

        return Arrays.asList(
                new Responsavel(1L, "Prof. João", "12345678901"),
                new Responsavel(2L, "Prof. Maria", "23456789012"),
                new Responsavel(3L, "Prof. Carlos", "34567890123")
        );
    }


    public static List<Reserva> getReservas() {

        return Arrays.asList(
                new Reserva(1L, "Aula de Matemática", TipoEvento.SEMINARIO, getResponsaveis().get(0), "joao@example.com", LocalDateTime.of(2023, 1, 10, 8, 0), Periodo.MATUTINO, Turno.PRIMEIRO, getEspacosFisicos().get(0), LocalDateTime.of(2023, 1, 10, 8, 0), LocalDateTime.of(2023, 1, 10, 10, 0), 30, SituacaoReserva.CONFIRMADA),
                new Reserva(2L, "Palestra de Tecnologia", TipoEvento.WORKSHOP, getResponsaveis().get(1), "maria@example.com", LocalDateTime.of(2023, 1, 15, 14, 0), Periodo.VESPERTINO, Turno.SEGUNDO, getEspacosFisicos().get(1), LocalDateTime.of(2023, 1, 15, 14, 0), LocalDateTime.of(2023, 1, 15, 16, 0), 150, SituacaoReserva.CONFIRMADA),
                new Reserva(3L, "Reuniao sobre Programação", TipoEvento.REUNIAO, getResponsaveis().get(2), "carlos@example.com", LocalDateTime.of(2023, 1, 20, 10, 0), Periodo.MATUTINO, Turno.SEGUNDO, getEspacosFisicos().get(2), LocalDateTime.of(2023, 1, 20, 10, 0), LocalDateTime.of(2023, 1, 20, 12, 0), 20, SituacaoReserva.CANCELADA)
        );
    }


}