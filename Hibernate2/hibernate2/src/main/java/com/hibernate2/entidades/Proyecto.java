package com.hibernate2.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class Proyecto {

    @Id
    @Column(length = 20)
    private String Nombre;

    @Column(name = "FechaInicio")
    private LocalDateTime FechaInicio;

    public Proyecto() {
    }

    public Proyecto(String nombre, LocalDateTime fechaInicio) {
        Nombre = nombre;
        FechaInicio = fechaInicio;
    }

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

    @Override
    public String toString() {
        return "Proyecto [Nombre=" + Nombre + ", FechaInicio=" + FechaInicio + ", getNombre()=" + getNombre()
                + ", getFechaInicio()=" + getFechaInicio() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
