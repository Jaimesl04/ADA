package com.hibernate2.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigador")
public class investigador {

    @Id
    @Column(name = "DNI", length = 9)
    private String DNI;

    @Column(name = "NombreCompleto", nullable = false)
    private String NombreCompleto;

    @Column(name = "Direccion")
    private String Direccion;

    @Column(name = "Telefono", length = 9)
    private String Telefono;

    @Column(name = "Localidad")
    private String Localidad;

    // RELACIONES
    // Investigador con proyecto
    @ManyToOne
    @JoinColumn(name = "nombre_proyecto")
    private proyecto proyecto;

    // Investigador con tabla intermedia
    @ManyToMany
    @JoinColumn(name = "investigador")
    private Set<investigador_conferencia> investigador_conferencias = new HashSet<>();

    // CONSTRUCTORES
    public investigador() {
    }

    public investigador(String dNI, String nombreCompleto) {
        DNI = dNI;
        NombreCompleto = nombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Set<investigador_conferencia> getInvestigador_conferencias() {
        return investigador_conferencias;
    }

    public void setInvestigador_conferencias(Set<investigador_conferencia> investigador_conferencias) {
        this.investigador_conferencias = investigador_conferencias;
    }

}
