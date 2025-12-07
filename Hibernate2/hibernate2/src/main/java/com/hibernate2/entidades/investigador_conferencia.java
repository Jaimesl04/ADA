package com.hibernate2.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigador_conferencia")
public class investigador_conferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "investigador_dni")
    private investigador investigador;

    @ManyToMany
    @JoinColumn(name = "conferencia_nombre")
    private conferencia conferencia;

    // CONSTRUCTORES
    public investigador_conferencia() {
    }

    public investigador_conferencia(Long id, com.hibernate2.entidades.investigador investigador,
            com.hibernate2.entidades.conferencia conferencia) {
        this.id = id;
        this.investigador = investigador;
        this.conferencia = conferencia;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador(investigador investigador) {
        this.investigador = investigador;
    }

    public conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(conferencia conferencia) {
        this.conferencia = conferencia;
    }

}
