package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.model.Diagnostico;
import com.sistemamedico.hospital.service.DiagnosticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @GetMapping
    public List<Diagnostico> listarTodos() {
        return diagnosticoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnostico> obtenerPorId(@PathVariable Long id) {
        return diagnosticoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Diagnostico> obtenerPorCodigo(@PathVariable String codigo) {
        Diagnostico diagnostico = diagnosticoService.buscarPorCodigo(codigo);
        if (diagnostico != null) {
            return ResponseEntity.ok(diagnostico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Diagnostico> crearDiagnostico(@RequestBody Diagnostico diagnostico) {
        Diagnostico guardado = diagnosticoService.guardar(diagnostico);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDiagnostico(@PathVariable Long id) {
        diagnosticoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
