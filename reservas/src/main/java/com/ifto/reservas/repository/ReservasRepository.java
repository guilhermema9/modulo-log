package com.ifto.reservas.repository;

import com.ifto.reservas.model.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<Reservas,Long> {
}
