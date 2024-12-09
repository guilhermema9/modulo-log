package com.ifto.reservas.controller;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/espaco")
public class EspacoFisicoController {

    @Autowired
    EspacoFisicoRepository espacoFisicoRepository;

    @GetMapping("/list")
    List<EspacoFisico> alunoList() {
        return espacoFisicoRepository.findAll();
    }


}
