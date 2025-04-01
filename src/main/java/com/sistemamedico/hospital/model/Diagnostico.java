package com.sistemamedico.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_diag", nullable = false)
    private String nombreDiag;

    @Column(unique = true, nullable = false)
    private String codigo;

    // Constructores
    public Diagnostico() {}

    public Diagnostico(String nombreDiag, String codigo) {
        this.nombreDiag = nombreDiag;
        this.codigo = codigo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDiag() {
        return nombreDiag;
    }

    public void setNombreDiag(String nombreDiag) {
        this.nombreDiag = nombreDiag;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
