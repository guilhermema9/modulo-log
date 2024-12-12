package com.ifto.reservas.controller;

import com.ifto.reservas.model.Reservas;
import com.ifto.reservas.model.enums.SituacaoReserva;
import com.ifto.reservas.model.enums.TipoEspaco;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import com.ifto.reservas.repository.ReservasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api/reservas")
public class ReservasController {
    @Autowired
    ReservasRepository reservasRepository;

    @GetMapping("/list")
    List<Reservas> espacoFisicosList() {
        return reservasRepository.findAll();
    }

    @GetMapping("/{idReserva}")
    Optional<Reservas> espacoById(@PathVariable Long idReserva) {
        return reservasRepository.findById(idReserva);
    }


    @DeleteMapping("/deletar/{idReserva}")
    void deletar(@PathVariable Long idReserva) {
        reservasRepository.deleteById(idReserva);
    }

    @PutMapping("/save")
    Reservas save(@RequestBody Reservas espacoFisico) {
        return reservasRepository.save(espacoFisico);
    }

    @GetMapping("/filtro-personalizado")
    public ResponseEntity<List<Reservas>> filtroPersonalizadoReservas(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
            @RequestParam(required = false) TipoEspaco tipoEspaco,
            @RequestParam(required = false) String responsavel,
            @RequestParam(required = false) SituacaoReserva situacao
    ) {
        List<Reservas> reservas = reservasRepository.findByFiltrosPersonalizados(
                dataInicio, dataFim, tipoEspaco, responsavel, situacao
        );
        return ResponseEntity.ok(reservas);
    }
}
