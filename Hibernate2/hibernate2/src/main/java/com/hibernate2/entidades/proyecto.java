package com.hibernate2.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class proyecto {

    @Id
    @Column(length = 20)
    private String Nombre;

    @Column(name = "FechaInicio")
    private LocalDateTime FechaInicio;

    // Relaciones
    @OneToMany(mappedBy = "Proyecto")
    private List<investigador> investigadores = new ArrayList<>();

    // Constructores
    public proyecto() {
    }

    public proyecto(String nombre, LocalDateTime fechaInicio) {
        Nombre = nombre;
        FechaInicio = fechaInicio;
    }

    // Getters y Setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public LocalDateTime getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public List<investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(List<investigador> investigadores) {
        this.investigadores = investigadores;
    }

    // toString
    @Override
    public String toString() {
        return "Proyecto [Nombre=" + Nombre + ", FechaInicio=" + FechaInicio + "]";
    }

}
