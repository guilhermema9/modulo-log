package com.ifto.reservas.repository;


import com.ifto.reservas.model.EspacoFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacoFisicoRepository extends JpaRepository<EspacoFisico, Long> {
}
