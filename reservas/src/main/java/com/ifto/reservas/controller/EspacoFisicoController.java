package com.ifto.reservas.controller;

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

        return espacoFisicoRepository.findById(idEspaco);
    }


    @PostMapping("/add")
    EspacoFisico cadastrar(@RequestBody EspacoFisico espacoFisico) {

        return espacoFisicoRepository.save(espacoFisico);
    }


    @DeleteMapping("/deletar/{idEspaco}")
    void deletar(@PathVariable Long idEspaco) {

        espacoFisicoRepository.deleteById(idEspaco);
    }


    @PutMapping("/editar/{idEspaco}")
    EspacoFisico editar(@RequestBody EspacoFisico espacoFisico) {

        return espacoFisicoRepository.save(espacoFisico);
    }
}
