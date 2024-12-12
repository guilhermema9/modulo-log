package com.ifto.reservas.repository;

import com.ifto.reservas.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    @Query("SELECT r FROM Responsavel r WHERE " +
            "(:nome IS NULL OR r.nome LIKE %:nome%) AND " +
            "(:cpf IS NULL OR r.cpf = :cpf)")
    List<Responsavel> findByFiltrosPersonalizados(
            @Param("nome") String nome,
            @Param("cpf") String cpf
    );
}