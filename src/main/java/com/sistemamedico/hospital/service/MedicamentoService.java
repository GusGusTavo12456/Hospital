package com.sistemamedico.hospital.service;

import com.sistemamedico.hospital.model.Medicamento;
import com.sistemamedico.hospital.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> buscarPorId(Long id) {
        return medicamentoRepository.findById(id);
    }

    public List<Medicamento> buscarPorPacienteId(Long pacienteId) {
        return medicamentoRepository.findByPacienteId(pacienteId);
    }

    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void eliminar(Long id) {
        medicamentoRepository.deleteById(id);
    }
}
