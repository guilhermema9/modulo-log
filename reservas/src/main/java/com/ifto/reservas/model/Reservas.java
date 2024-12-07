package com.ifto.reservas.model;

import java.time.LocalDateTime;

import com.ifto.reservas.model.enums.SituacaoReserva;
import com.ifto.reservas.model.enums.TipoEvento;
import com.ifto.reservas.model.enums.Periodo;
import com.ifto.reservas.model.enums.Turno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Reservas {
    @Id
    @GeneratedValue
    private Long id;
    @JoinColumn(nullable = false)
    private String nomeEvento;
    @JoinColumn(nullable = false)
    private TipoEvento tipoEvento;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Responsavel responsavel;
    @JoinColumn(nullable = false)
    private String contatoResponsavel;
    @JoinColumn(nullable = false)
    private LocalDateTime dataReserva;
    @JoinColumn(nullable = false)
    private Periodo periodo;
    @JoinColumn(nullable = false)
    private Turno turno;
    @ManyToOne
    @JoinColumn(nullable = false)
    private EspacoFisico espacoFisico;
    @JoinColumn(nullable = false)
    private LocalDateTime horaInicio;
    @JoinColumn(nullable = false)
    private LocalDateTime horaTermino;
    @JoinColumn(nullable = false)
    private int totalParticipantes;
    @JoinColumn(nullable = false)
    private SituacaoReserva situacao;
}