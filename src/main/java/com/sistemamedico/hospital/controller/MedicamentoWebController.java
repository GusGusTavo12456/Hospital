package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.model.Medicamento;
import com.sistemamedico.hospital.model.Paciente;
import com.sistemamedico.hospital.service.MedicamentoService;
import com.sistemamedico.hospital.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedicamentoWebController {

    private final MedicamentoService medicamentoService;
    private final PacienteService pacienteService;

    public MedicamentoWebController(MedicamentoService medicamentoService, PacienteService pacienteService) {
        this.medicamentoService = medicamentoService;
        this.pacienteService = pacienteService;
    }

    @GetMapping("/medicamentos")
    public String listarMedicamentos(Model model) {
        model.addAttribute("medicamentos", medicamentoService.listarTodos());
        return "medicamentos";
    }

    @GetMapping("/medicamentos/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        List<Paciente> pacientes = pacienteService.listarTodos();
        model.addAttribute("pacientes", pacientes);
        return "registrar_medicamento";
    }

    @PostMapping("/medicamentos/guardar")
    public String guardarMedicamento(@ModelAttribute Medicamento medicamento) {
        medicamentoService.guardar(medicamento);
        return "redirect:/medicamentos";
    }
}
