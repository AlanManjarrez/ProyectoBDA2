/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author uirtis
 */
@Entity (name = "tramites")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "fecha_emision", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaEmision;
    
    @Column (name = "costo", nullable = false) 
    private Float costo;
    
    @Column (name = "vigencia", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar vigencia;
    
    @ManyToOne (cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "id_persona", referencedColumnName = "id") 
    private Persona personas;

    public Tramite() {
    }

    public Tramite(Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.vigencia = vigencia;
        this.personas = personas;
    }

    public Tramite(Long id, Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.vigencia = vigencia;
        this.personas = personas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float Costo) {
        this.costo = Costo;
    }

    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

    public Persona getPersonas() {
        return personas;
    }

    public void setPersonas(Persona personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaEmision=" + fechaEmision + ", Costo=" + costo + ", vigencia=" + vigencia + ", personas=" + personas + '}';
    }
}
