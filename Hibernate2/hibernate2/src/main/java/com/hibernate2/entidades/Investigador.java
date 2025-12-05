package com.hibernate2.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Investigador")
public class Investigador {

    @Id
    @Column(name = "DNI", length = 9)
    private String DNI;

    @Column(name = "NombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono", length = 9)
    private String telefono;

    @Column(name = "Localidad")
    private String localidad;

    public Investigador(String dNI, String nombreCompleto, String direccion, String telefono, String localidad) {
        DNI = dNI;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
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

    @Override
    public String toString() {
        return "Investigador [DNI=" + DNI + ", nombreCompleto=" + nombreCompleto + ", direccion=" + direccion
                + ", telefono=" + telefono + ", localidad=" + localidad + ", getDNI()=" + getDNI()
                + ", getNombreCompleto()=" + getNombreCompleto() + ", getDireccion()=" + getDireccion()
                + ", getTelefono()=" + getTelefono() + ", getClass()=" + getClass() + ", getLocalidad()="
                + getLocalidad() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    

    
    

}
