package com.hibernate2.entidades;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "conferencia")
public class conferencia {

    @Id
    @Column(name = "Nombre", length = 100)
    private String Nombre;

    @Column(name = "FechaHoraInicio")
    private LocalDateTime FechaHoraInicio;

    @Column(name = "Lugar")
    private String Lugar;

    @Column(name = "NumeroHoras")
    private Double NumeroHoras;

    // RELACIONES
    @ManyToMany(mappedBy = "conferencia")
    private Set<investigador_conferencia> investigador_conferencias = new HashSet<>();

    // CONSTRUCTORES
    public conferencia() {
    }

    public conferencia(String nombre, LocalDateTime fechaHoraInicio, String lugar, Double numeroHoras) {
        Nombre = nombre;
        FechaHoraInicio = fechaHoraInicio;
        Lugar = lugar;
        NumeroHoras = numeroHoras;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public LocalDateTime getFechaHoraInicio() {
        return FechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        FechaHoraInicio = fechaHoraInicio;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public Double getNumeroHoras() {
        return NumeroHoras;
    }

    public void setNumeroHoras(Double numeroHoras) {
        NumeroHoras = numeroHoras;
    }

    public Set<investigador_conferencia> getInvestigador_conferencias() {
        return investigador_conferencias;
    }

    public void setInvestigador_conferencias(Set<investigador_conferencia> investigador_conferencias) {
        this.investigador_conferencias = investigador_conferencias;
    }

}
