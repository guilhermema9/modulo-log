package com.ifto.reservas.controller;

import com.ifto.reservas.model.Reservas;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import com.ifto.reservas.repository.ReservasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/add")
    Reservas cadastrar(@RequestBody Reservas espacoFisico) {

        return reservasRepository.save(espacoFisico);
    }


    @DeleteMapping("/deletar/{idReserva}")
    void deletar(@PathVariable Long idReserva) {

        reservasRepository.deleteById(idReserva);
    }


    @PutMapping("/editar")
    Reservas editar(@RequestBody Reservas espacoFisico) {

        return reservasRepository.save(espacoFisico);
    }
}
