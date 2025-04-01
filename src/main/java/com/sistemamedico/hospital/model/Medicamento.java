package com.sistemamedico.hospital.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_medi", nullable = false)
    private String nombreMedi;

    private int cantidad;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    private int concentracion;

    // Relación con Paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Constructores
    public Medicamento() {}

    public Medicamento(String nombreMedi, int cantidad, LocalDate fechaVencimiento, int concentracion, Paciente paciente) {
        this.nombreMedi = nombreMedi;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
        this.concentracion = concentracion;
        this.paciente = paciente;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMedi() {
        return nombreMedi;
    }

    public void setNombreMedi(String nombreMedi) {
        this.nombreMedi = nombreMedi;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
