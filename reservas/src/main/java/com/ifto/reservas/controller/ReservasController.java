package com.ifto.reservas.controller;

import com.ifto.reservas.controller.errors.EspacoNotFoundExeption;
import com.ifto.reservas.controller.errors.ReservasNotFoundExeption;
import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.Reserva;
import com.ifto.reservas.model.enums.SituacaoReserva;
import com.ifto.reservas.model.enums.TipoEspaco;
import com.ifto.reservas.repository.ReservasRepository;
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
@RequestMapping("/api/reservas")
public class ReservasController {
    @Autowired
    ReservasRepository reservasRepository;


    @GetMapping("/all")
    CollectionModel<EntityModel<Reserva>> all() {

        List<EntityModel<Reserva>> reservas = reservasRepository.findAll().stream()
                .map(reserva -> EntityModel.of(reserva,
                        linkTo(methodOn(ReservasController.class).one(reserva.getId())).withSelfRel(),
                        linkTo(methodOn(ReservasController.class).all()).withRel("Reservas")))
                .collect(Collectors.toList());
        return CollectionModel.of(reservas,linkTo(methodOn(ReservasController.class).all()).withSelfRel());
    }
    @GetMapping("/{idReserva}")
    EntityModel<Reserva> one(@PathVariable Long idReserva) {

        Reserva reserva = reservasRepository.findById(idReserva).orElseThrow(
                () -> new ReservasNotFoundExeption(idReserva)
        );
        return  EntityModel.of(reserva,
                linkTo(methodOn(ReservasController.class).one(idReserva)).withSelfRel(),
                linkTo(methodOn(ReservasController.class).all()).withRel("Reservas"));
    }


    @DeleteMapping("/deletar/{idReserva}")
    void delete(@PathVariable Long idReserva) {

        reservasRepository.deleteById(idReserva);
    }


    @PutMapping("/save")
    Reserva save(@RequestBody Reserva espacoFisico) {

        return reservasRepository.save(espacoFisico);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Reserva>> filtroPersonalizadoReservas(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
            @RequestParam(required = false) TipoEspaco tipoEspaco,
            @RequestParam(required = false) String responsavel,
            @RequestParam(required = false) SituacaoReserva situacao
    ) {

        List<Reserva> reservas = reservasRepository.findByFiltrosPersonalizados(
                dataInicio, dataFim, tipoEspaco, responsavel, situacao
        );
        return ResponseEntity.ok(reservas);
    }


}
