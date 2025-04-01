package com.sistemamedico.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_doc", nullable = false)
    private String nombreDoc;

    @Column(unique = true, nullable = false)
    private String dni;

    // Relación con Especialidad (Muchos doctores pueden tener una especialidad)
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;

    // Constructores
    public Doctor() {}

    public Doctor(String nombreDoc, String dni, Especialidad especialidad) {
        this.nombreDoc = nombreDoc;
        this.dni = dni;
        this.especialidad = especialidad;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
