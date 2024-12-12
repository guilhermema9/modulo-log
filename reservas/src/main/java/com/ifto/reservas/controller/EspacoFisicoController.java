package com.ifto.reservas.controller;

import com.ifto.reservas.controller.errors.EspacoNotFoundExeption;
import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.Reserva;
import com.ifto.reservas.model.enums.SituacaoEspaco;
import com.ifto.reservas.model.enums.SituacaoReserva;
import com.ifto.reservas.model.enums.TipoEspaco;
import com.ifto.reservas.repository.EspacoFisicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Transactional
@RestController
@RequestMapping("/api/espaco")
public class EspacoFisicoController {

    @Autowired
    EspacoFisicoRepository espacoFisicoRepository;
    @GetMapping("/all")
    CollectionModel<EntityModel<EspacoFisico>> all() {

        List<EntityModel<EspacoFisico>> espacos = espacoFisicoRepository.findAll().stream()
                .map(espacoFisico -> EntityModel.of(espacoFisico,
                        linkTo(methodOn(EspacoFisicoController.class).one(espacoFisico.getId())).withSelfRel(),
                        linkTo(methodOn(EspacoFisicoController.class).all()).withRel("Espaços")))
                .collect(Collectors.toList());

        return CollectionModel.of(espacos,linkTo(methodOn(EspacoFisicoController.class).all()).withSelfRel());
    }
    @GetMapping("/{idEspaco}")
    EntityModel<EspacoFisico> one(@PathVariable Long idEspaco) {

        EspacoFisico espacoFisico = espacoFisicoRepository.findById(idEspaco).orElseThrow(
                () -> new EspacoNotFoundExeption(idEspaco)
        );
        return  EntityModel.of(espacoFisico,
                linkTo(methodOn(EspacoFisicoController.class).one(idEspaco)).withSelfRel(),
                linkTo(methodOn(EspacoFisicoController.class).all()).withRel("Espaços"));
    }

    @DeleteMapping("/deletar/{idEspaco}")
    void delete(@PathVariable Long idEspaco) {

        espacoFisicoRepository.deleteById(idEspaco);
    }

    @PutMapping("/save")
    EspacoFisico save(@RequestBody EspacoFisico espacoFisico) {
        return espacoFisicoRepository.save(espacoFisico);
    }
    @GetMapping("/filter")
    List<EspacoFisico> filterByCustom(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) TipoEspaco tipo,
            @RequestParam(required = false) SituacaoEspaco situacao) {
        return espacoFisicoRepository.findByFiltrosPersonalizados(nome, tipo, situacao);
    }
}
