package com.sistemamedico.hospital.controller;

import com.sistemamedico.hospital.model.Doctor;
import com.sistemamedico.hospital.model.Especialidad;
import com.sistemamedico.hospital.service.DoctorService;
import com.sistemamedico.hospital.service.EspecialidadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DoctorWebController {

    private final DoctorService doctorService;
    private final EspecialidadService especialidadService;

    public DoctorWebController(DoctorService doctorService, EspecialidadService especialidadService) {
        this.doctorService = doctorService;
        this.especialidadService = especialidadService;
    }

    @GetMapping("/doctores")
    public String listarDoctores(Model model) {
        model.addAttribute("doctores", doctorService.listarTodos());
        return "doctores";
    }

    @GetMapping("/doctores/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("doctor", new Doctor());
        List<Especialidad> especialidades = especialidadService.listarTodas();
        model.addAttribute("especialidades", especialidades);
        return "registrar_doctor";
    }

    @PostMapping("/doctores/guardar")
    public String guardarDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.guardar(doctor);
        return "redirect:/doctores";
    }
}
