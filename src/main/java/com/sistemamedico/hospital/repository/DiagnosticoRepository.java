package com.sistemamedico.hospital.repository;

import com.sistemamedico.hospital.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
    Diagnostico findByCodigo(String codigo);
}
