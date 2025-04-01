package com.sistemamedico.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_especi", nullable = false)
    private String nombreEspeci;

    @Column(unique = true, nullable = false)
    private String codigo;

    // Constructores
    public Especialidad() {}

    public Especialidad(String nombreEspeci, String codigo) {
        this.nombreEspeci = nombreEspeci;
        this.codigo = codigo;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEspeci() {
        return nombreEspeci;
    }

    public void setNombreEspeci(String nombreEspeci) {
        this.nombreEspeci = nombreEspeci;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
