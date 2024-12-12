package com.ifto.reservas.repository;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.Reserva;
import com.ifto.reservas.model.Responsavel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DataInitializer {

    @Autowired
    private EspacoFisicoRepository espacoFisicoRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ReservasRepository reservasRepository;

    @PostConstruct
    @Transactional
    public void insertMockData() {
        // Inserir dados de EspacoFisico
        for (EspacoFisico espacoFisico : Mock.getEspacosFisicos()) {
            espacoFisicoRepository.save(espacoFisico);
        }

        // Inserir dados de Responsavel
        for (Responsavel responsavel : Mock.getResponsaveis()) {
            responsavelRepository.save(responsavel);
        }

        // Inserir dados de Reserva
        for (Reserva reserva : Mock.getReservas()) {
            reservasRepository.save(reserva);
        }
    }
}