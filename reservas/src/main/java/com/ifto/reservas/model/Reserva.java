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
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeEvento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEvento tipoEvento;

    @ManyToOne
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Responsavel responsavel;

    @Column(nullable = false)
    private String contatoResponsavel;

    @Column(nullable = false)
    private LocalDateTime dataReserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodo periodo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "espaco_fisico_id", nullable = false)
    private EspacoFisico espacoFisico;

    @Column(nullable = false)
    private LocalDateTime horaInicio;

    @Column(nullable = false)
    private LocalDateTime horaTermino;

    @Column(nullable = false)
    private int totalParticipantes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoReserva situacao;
}
