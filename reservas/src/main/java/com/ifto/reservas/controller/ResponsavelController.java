package com.ifto.reservas.controller;

import com.ifto.reservas.controller.errors.ReservasNotFoundExeption;
import com.ifto.reservas.controller.errors.ResponsavelNotFoundExeption;
import com.ifto.reservas.model.Responsavel;
import com.ifto.reservas.repository.ResponsavelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Transactional
@RestController
@RequestMapping("/api/responsavel")
public class ResponsavelController {
    @Autowired
    ResponsavelRepository responsavelRepository;

    @GetMapping("/all")
    CollectionModel<EntityModel<Responsavel>> all() {

        List<EntityModel<Responsavel>> responsavel = responsavelRepository.findAll().stream()
                .map(reserva -> EntityModel.of(reserva,
                        linkTo(methodOn(ResponsavelController.class).one(reserva.getId())).withSelfRel(),
                        linkTo(methodOn(ResponsavelController.class).all()).withRel("Responsavel")))
                .collect(Collectors.toList());
        return CollectionModel.of(responsavel,linkTo(methodOn(ResponsavelController.class).all()).withSelfRel());
    }
    @GetMapping("/{idResponsavel}")
    EntityModel<Responsavel> one(@PathVariable Long idResponsavel) {

        Responsavel reserva = responsavelRepository.findById(idResponsavel).orElseThrow(
                () -> new ResponsavelNotFoundExeption(idResponsavel)
        );
        return  EntityModel.of(reserva,
                linkTo(methodOn(ResponsavelController.class).one(idResponsavel)).withSelfRel(),
                linkTo(methodOn(ResponsavelController.class).all()).withRel("Responsavel"));
    }
    @DeleteMapping("/deletar/{idEspaco}")
    void deletar(@PathVariable Long idEspaco) {

        responsavelRepository.deleteById(idEspaco);
    }
    @PutMapping("/save")
    Responsavel save(@RequestBody Responsavel responsavel) {

        return responsavelRepository.save(responsavel);
    }
    @GetMapping("/filter")
    List<Responsavel> filterByCustom(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        return responsavelRepository.findByFiltrosPersonalizados(nome, cpf);
    }
}
