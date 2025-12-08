package com.hibernate2.entidades;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "conferencia")
public class conferencia {

    @Id
    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "FechaHoraInicio")
    private Date fechaHoraInicio;

    @Column(name = "Lugar")
    private String lugar;

    @Column(name = "NumeroHoras")
    private Double numeroHoras;

    // RELACIONES
    @OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<investigador_conferencia> asistencias = new HashSet<>();

    // CONSTRUCTORES
    public conferencia() {
    }

    public conferencia(String nombre, Date fechaHoraInicio, String lugar, Double numeroHoras) {
        this.nombre = nombre;
        this.fechaHoraInicio = fechaHoraInicio;
        this.lugar = lugar;
        this.numeroHoras = numeroHoras;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Double getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Double numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Set<investigador_conferencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Set<investigador_conferencia> asistencias) {
        this.asistencias = asistencias;
    }

    // toString
    @Override
    public String toString() {
        return "conferencia [nombre=" + nombre + ", fechaHoraInicio=" + fechaHoraInicio + ", lugar=" + lugar + "]";
    }

}