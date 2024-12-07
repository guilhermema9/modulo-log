package com.ifto.reservas.model;

import java.time.LocalDateTime;

import com.ifto.reservas.model.enums.SituacaoEspaco;
import com.ifto.reservas.model.enums.TipoEspaco;
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
public class EspacoFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEspaco tipo;

    @Column(nullable = false)
    private int capacidade;

    @Column(nullable = false)
    private String recursos;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private LocalDateTime dataProcedimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoEspaco situacao;

    @Column(nullable = false)
    private String localizacao;

    @Column
    private String notasAdicionais;
}
