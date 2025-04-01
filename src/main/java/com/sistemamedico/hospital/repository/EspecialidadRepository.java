package com.sistemamedico.hospital.repository;

import com.sistemamedico.hospital.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    Especialidad findByCodigo(String codigo);
}
