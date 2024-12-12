package com.ifto.reservas.repository;

import com.ifto.reservas.model.EspacoFisico;
import com.ifto.reservas.model.enums.SituacaoEspaco;
import com.ifto.reservas.model.enums.TipoEspaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacoFisicoRepository extends JpaRepository<EspacoFisico, Long> {

    @Query("SELECT e FROM EspacoFisico e WHERE " +
            "(:nome IS NULL OR e.nome LIKE %:nome%) AND " +
            "(:tipo IS NULL OR e.tipo = :tipo) AND " +
            "(:situacao IS NULL OR e.situacao = :situacao)")
    List<EspacoFisico> findByFiltrosPersonalizados(
            @Param("nome") String nome,
            @Param("tipo") TipoEspaco tipo,
            @Param("situacao") SituacaoEspaco situacao
    );
}