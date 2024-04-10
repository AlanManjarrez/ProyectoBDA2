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
 *  Clase JPA de tramite
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
    
    private String tipo;
    
    @ManyToOne (cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "id_persona", referencedColumnName = "id") 
    private Persona personas;

     /**
     * Constructor por omisión
     */
    public Tramite() {
    }

    /**
     * Constructor con fecha de emisión, costo y persona asociada
     *
     * @param fechaEmision Fecha de emisión del trámite
     * @param costo        Costo del trámite
     * @param personas     Persona asociada al trámite
     */
    public Tramite(Calendar fechaEmision, Float costo, Persona personas) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.personas = personas;
    }

    /**
     * Constructor con identificador, fecha de emisión, costo y persona asociada
     *
     * @param id           Identificador del trámite
     * @param fechaEmision Fecha de emisión del trámite
     * @param costo        Costo del trámite
     * @param personas     Persona asociada al trámite
     */
    public Tramite(Long id, Calendar fechaEmision, Float costo, Persona personas) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.personas = personas;
    }

    /**
     * Método para obtener el identificador del trámite
     *
     * @return El identificador del trámite
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el identificador del trámite
     *
     * @param id El identificador del trámite
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener la fecha de emisión del trámite
     *
     * @return La fecha de emisión del trámite
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Método para establecer la fecha de emisión del trámite
     *
     * @param fechaEmision La fecha de emisión del trámite
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Método para obtener el costo del trámite
     *
     * @return El costo del trámite
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Método para establecer el costo del trámite
     *
     * @param costo El costo del trámite
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Método para obtener la persona asociada al trámite
     *
     * @return La persona asociada al trámite
     */
    public Persona getPersonas() {
        return personas;
    }

    /**
     * Método para establecer la persona asociada al trámite
     *
     * @param personas La persona asociada al trámite
     */
    public void setPersonas(Persona personas) {
        this.personas = personas;
    }

    /**
     * Método para obtener el tipo de trámite
     *
     * @return El tipo de trámite
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para establecer el tipo de trámite
     *
     * @param tipo El tipo de trámite
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método para obtener una representación de cadena del trámite
     *
     * @return Una cadena que representa el trámite
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaEmision=" + fechaEmision + ", Costo=" + costo  + ", personas=" + personas + '}';
    }
}
