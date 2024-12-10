package com.ifto.reservas.repository;

import com.ifto.reservas.model.Reservas;
import com.ifto.reservas.model.enums.SituacaoReserva;
import com.ifto.reservas.model.enums.TipoEspaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservasRepository extends JpaRepository<Reservas,Long> {

    @Query("SELECT r FROM Reservas r WHERE " +
            "(:dataInicio IS NULL OR r.horaInicio >= :dataInicio) AND " +
            "(:dataFim IS NULL OR r.horaTermino <= :dataFim) AND " +
            "(:tipoEspaco IS NULL OR r.espacoFisico.tipo = :tipoEspaco) AND " +
            "(:responsavel IS NULL OR r.responsavel.nome LIKE %:responsavel%) AND " +
            "(:situacao IS NULL OR r.situacao = :situacao)")
    List<Reservas> findByFiltrosPersonalizados(
            @Param("dataInicio") LocalDateTime dataInicio,
            @Param("dataFim") LocalDateTime dataFim,
            @Param("tipoEspaco") TipoEspaco tipoEspaco,
            @Param("responsavel") String responsavel,
            @Param("situacao") SituacaoReserva situacao
    );
}