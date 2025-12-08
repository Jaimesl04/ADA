package com.hibernate2.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "investigador")
public class investigador {

    @Id
    @Column(name = "DNI", length = 9)
    private String dni;

    @Column(name = "NombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono", length = 9)
    private String telefono;

    @Column(name = "Localidad")
    private String localidad;

    // RELACIÓN CON PROYECTO
    @ManyToOne
    @JoinColumn(name = "nombre_proyecto")
    private proyecto proyecto;

    // RELACIÓN CON TABLA INTERMEDIA
    @OneToMany(mappedBy = "investigador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<investigador_conferencia> investigadorConferencias = new HashSet<>();

    // CONSTRUCTORES
    public investigador() {
    }

    public investigador(String dni, String nombreCompleto, String direccion, String telefono, String localidad) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    // GETTERS Y SETTERS
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Set<investigador_conferencia> getAsistenciasConferencias() {
        return investigadorConferencias;
    }

    public void setAsistenciasConferencias(Set<investigador_conferencia> asistenciasConferencias) {
        this.investigadorConferencias = asistenciasConferencias;
    }

    // toString
    @Override
    public String toString() {
        return "investigador [dni=" + dni + ", nombreCompleto=" + nombreCompleto + "]";
    }

}