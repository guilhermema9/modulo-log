package com.ifto.reservas.model;

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
public class Responsavel {
    @Id
    @GeneratedValue
    private Long id;
    @JoinColumn(nullable = false)
    private String nome;
    @JoinColumn(nullable = false)
    private String cpf;


}
