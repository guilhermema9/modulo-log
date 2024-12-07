package com.ifto.reservas.model.configuration;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.Reservas;
import com.ifto.reservas.model.Responsavel;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import com.ifto.reservas.repository.ReservasRepository;
import com.ifto.reservas.repository.ResponsavelRepository;
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

        // Inserir dados de Reservas
        for (Reservas reservas : Mock.getReservas()) {
            reservasRepository.save(reservas);
        }
    }
}