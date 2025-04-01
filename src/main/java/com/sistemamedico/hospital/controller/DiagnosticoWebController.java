package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.model.Diagnostico;
import com.sistemamedico.hospital.service.DiagnosticoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiagnosticoWebController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoWebController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @GetMapping("/diagnosticos")
    public String listarDiagnosticos(Model model) {
        model.addAttribute("diagnosticos", diagnosticoService.listarTodos());
        return "diagnosticos";
    }

    @GetMapping("/diagnosticos/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("diagnostico", new Diagnostico());
        return "registrar_diagnostico";
    }

    @PostMapping("/diagnosticos/guardar")
    public String guardarDiagnostico(@ModelAttribute Diagnostico diagnostico) {
        diagnosticoService.guardar(diagnostico);
        return "redirect:/diagnosticos";
    }
}
