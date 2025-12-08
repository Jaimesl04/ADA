package com.hibernate2.entidades;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "proyecto")
public class proyecto {

    @Id
    @Column(name = "Nombre", length = 20)
    private String nombre;

    @Column(name = "FechaInicio")
    private Date fechaInicio;

    // RELACIONES
    @OneToMany(mappedBy = "proyecto")
    private Set<investigador> investigadores = new HashSet<>();

    // CONSTRUCTORES
    public proyecto() {
    }

    public proyecto(String nombre, Date fechaInicio) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Set<investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(Set<investigador> investigadores) {
        this.investigadores = investigadores;
    }

    // toString
    @Override
    public String toString() {
        return "proyecto [nombre=" + nombre + ", fechaInicio=" + fechaInicio + "]";
    }

}