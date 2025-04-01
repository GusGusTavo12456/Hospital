package com.sistemamedico.hospital.service;

import com.sistemamedico.hospital.model.Diagnostico;
import com.sistemamedico.hospital.repository.DiagnosticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;

    public DiagnosticoService(DiagnosticoRepository diagnosticoRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
    }

    public List<Diagnostico> listarTodos() {
        return diagnosticoRepository.findAll();
    }

    public Optional<Diagnostico> buscarPorId(Long id) {
        return diagnosticoRepository.findById(id);
    }

    public Diagnostico buscarPorCodigo(String codigo) {
        return diagnosticoRepository.findByCodigo(codigo);
    }

    public Diagnostico guardar(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    public void eliminar(Long id) {
        diagnosticoRepository.deleteById(id);
    }
}
