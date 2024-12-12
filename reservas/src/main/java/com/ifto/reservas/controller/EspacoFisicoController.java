package com.ifto.reservas.controller;

import com.ifto.reservas.controller.errors.EspacoNotFoundExeption;
import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api/espaco")
public class EspacoFisicoController {

    @Autowired
    EspacoFisicoRepository espacoFisicoRepository;

    @GetMapping("/list")
    List<EspacoFisico> espacoFisicosList() {

        return espacoFisicoRepository.findAll();
    }

    @GetMapping("/{idEspaco}")
    Optional<EspacoFisico> espacoById(@PathVariable Long idEspaco) {

        return Optional.ofNullable(espacoFisicoRepository.findById(idEspaco).orElseThrow(
                () -> new EspacoNotFoundExeption(idEspaco))
        );
    }

    @DeleteMapping("/deletar/{idEspaco}")
    void deletar(@PathVariable Long idEspaco) {

        espacoFisicoRepository.deleteById(idEspaco);
    }

    @PutMapping("/save")
    EspacoFisico save(@RequestBody EspacoFisico espacoFisico) {
        return espacoFisicoRepository.save(espacoFisico);
    }
}
