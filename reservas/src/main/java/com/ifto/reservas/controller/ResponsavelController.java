package com.ifto.reservas.controller;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.Responsavel;
import com.ifto.reservas.repository.ResponsavelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping("/api/responsavel")
public class ResponsavelController {
    @Autowired
    ResponsavelRepository responsavelRepository;

    @GetMapping("/list")
    List<Responsavel> espacoFisicosList() {

        return responsavelRepository.findAll();
    }


    @GetMapping("/{idEspaco}")
    Optional<Responsavel> espacoById(@PathVariable Long idEspaco) {

        return responsavelRepository.findById(idEspaco);
    }

    @DeleteMapping("/deletar/{idEspaco}")
    void deletar(@PathVariable Long idEspaco) {

        responsavelRepository.deleteById(idEspaco);
    }


    @PutMapping("/save")
    Responsavel save(@RequestBody Responsavel responsavel) {

        return responsavelRepository.save(responsavel);
    }
}
