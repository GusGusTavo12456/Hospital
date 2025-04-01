package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.model.Medicamento;
import com.sistemamedico.hospital.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<Medicamento> listarTodos() {
        return medicamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> obtenerPorId(@PathVariable Long id) {
        return medicamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Medicamento> obtenerPorPacienteId(@PathVariable Long pacienteId) {
        return medicamentoService.buscarPorPacienteId(pacienteId);
    }

    @PostMapping
    public ResponseEntity<Medicamento> crearMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento guardado = medicamentoService.guardar(medicamento);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMedicamento(@PathVariable Long id) {
        medicamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
