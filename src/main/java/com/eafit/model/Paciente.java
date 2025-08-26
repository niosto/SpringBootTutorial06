package com.eafit.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;
    
    // Relación EAGER (carga inmediata) con Nutricionista
    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    @JsonBackReference
    private Nutricionista nutricionista;

    public void setNutricionista(Nutricionista nutricionista){this.nutricionista=nutricionista;}
    public Nutricionista getNutricionista(){return nutricionista;}

    //Relación LAZY con Notas
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Nota> notas = new ArrayList<>();
    
    public void setNotas(List<Nota> notas){this.notas=notas;}
    public List<Nota> getNotas(){return notas;}

    // Método helper para añadir notas
    public void addNota(Nota nota) {
        notas.add(nota);
        nota.setPaciente(this);
    }

    //Requerido por JPA
    public Paciente() {
    }

    public Paciente(String nombre, String apellido, LocalDate fechaNacimiento, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
    }


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

