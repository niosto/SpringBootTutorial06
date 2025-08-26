package com.eafit.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "tipo_nota", length = 50)
    private String tipoNota;

    // Relación EAGER con Paciente
    @ManyToOne()
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonBackReference
    private Paciente paciente;

    public Paciente getPaciente(){return paciente;}
    public void setPaciente(Paciente paciente){this.paciente=paciente;}

    // Relación LAZY con Nutricionista
    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    @JsonIgnoreProperties({"pacientes", "notas"})
    private Nutricionista nutricionista;


    public Nutricionista getNutricionista(){return nutricionista;}
    public void setNutricionista(Nutricionista nutricionista){this.nutricionista=nutricionista;}

    public Nota(){
    }

    public Nota(String titulo, String contenido, LocalDateTime fechaCreacion, String tipoNota){
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.tipoNota = tipoNota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }
}

