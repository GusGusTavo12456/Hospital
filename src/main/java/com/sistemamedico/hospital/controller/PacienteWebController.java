package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteWebController {

    private final PacienteService pacienteService;

    public PacienteWebController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientes")
    public String mostrarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "pacientes"; // nombre del archivo .html
    }
    @GetMapping("/pacientes/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("paciente", new com.sistemamedico.hospital.model.Paciente());
        return "registrar_paciente";
    }

    @PostMapping("/pacientes/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") com.sistemamedico.hospital.model.Paciente paciente) {
        pacienteService.guardar(paciente);
        return "redirect:/pacientes";
    }

}
