package com.sistemamedico.hospital.service;

import com.sistemamedico.hospital.model.Especialidad;
import com.sistemamedico.hospital.repository.EspecialidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> listarTodas() {
        return especialidadRepository.findAll();
    }

    public Optional<Especialidad> buscarPorId(Long id) {
        return especialidadRepository.findById(id);
    }

    public Especialidad buscarPorCodigo(String codigo) {
        return especialidadRepository.findByCodigo(codigo);
    }

    public Especialidad guardar(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public void eliminar(Long id) {
        especialidadRepository.deleteById(id);
    }
}
