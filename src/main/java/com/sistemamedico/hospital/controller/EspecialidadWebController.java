package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.model.Especialidad;
import com.sistemamedico.hospital.service.EspecialidadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EspecialidadWebController {

    private final EspecialidadService especialidadService;

    public EspecialidadWebController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping("/especialidades")
    public String listarEspecialidades(Model model) {
        model.addAttribute("especialidades", especialidadService.listarTodas());
        return "especialidades";
    }

    @GetMapping("/especialidades/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("especialidad", new Especialidad());
        return "registrar_especialidad";
    }

    @PostMapping("/especialidades/guardar")
    public String guardarEspecialidad(@ModelAttribute Especialidad especialidad) {
        especialidadService.guardar(especialidad);
        return "redirect:/especialidades";
    }
}
