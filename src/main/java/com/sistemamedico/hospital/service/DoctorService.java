package com.sistemamedico.hospital.service;

import com.sistemamedico.hospital.model.Doctor;
import com.sistemamedico.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> listarTodos() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> buscarPorId(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor buscarPorDni(String dni) {
        return doctorRepository.findByDni(dni);
    }

    public Doctor guardar(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }
}
