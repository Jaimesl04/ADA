package com.hibernate2.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "investigador_conferencia")
public class investigador_conferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "investigador_dni")
    private investigador investigador;

    @ManyToOne
    @JoinColumn(name = "conferencia_nombre")
    private conferencia conferencia;

    // CONSTRUCTORES
    public investigador_conferencia() {
    }

    public investigador_conferencia(investigador investigador, conferencia conferencia) {
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

    // toString
    @Override
    public String toString() {
        return "investigador_conferencia [investigador=" + investigador + ", conferencia=" + conferencia + "]";
    }

    
}
