package com.ifto.reservas.model;

import java.time.LocalDateTime;

import com.ifto.reservas.model.enums.SituacaoEspaco;
import com.ifto.reservas.model.enums.TipoEspaco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @GeneratedValue
    private Long id;
    @JoinColumn(nullable = false)
    private String nome;
    @JoinColumn(nullable = false)
    private String descricao;
    @JoinColumn(nullable = false)
    private TipoEspaco tipo;
    @JoinColumn(nullable = false)
    private int capacidade;
    @JoinColumn(nullable = false)
    private String recursos;
    @JoinColumn(nullable = false)
    private LocalDateTime dataCadastro;
    @JoinColumn(nullable = false)
    private LocalDateTime dataProcedimento;
    @JoinColumn(nullable = false)
    private SituacaoEspaco situacao;
    @JoinColumn(nullable = false)
    private String localizacao;
    @JoinColumn(nullable = false)
    private String notasAdicionais;
}