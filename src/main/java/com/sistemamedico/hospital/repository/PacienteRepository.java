package com.sistemamedico.hospital.repository;

import com.sistemamedico.hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByDni(String dni);
}
