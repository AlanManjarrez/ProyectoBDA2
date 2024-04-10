/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

import java.util.Calendar;

/**
 * Clase DTO de tramite
 * @author JESUS
 */
public class TramiteDTO {
    
    //Atributos de la clase
    private Long id;
    private Calendar fechaEmision;
    private Float costo;
    private PersonaDTO persona;
    private String tipo;

    /**
     * Constructor por omisión.
     */
    public TramiteDTO() {
    }

    /**
     * Constructor con parámetros para inicializar un trámite DTO.
     *
     * @param fechaEmision Fecha de emisión del trámite.
     * @param costo        Costo del trámite.
     * @param persona      Información de la persona asociada al trámite.
     */
    public TramiteDTO(Calendar fechaEmision, Float costo, PersonaDTO persona) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     * Constructor con parámetros para inicializar un trámite DTO con su identificador único.
     *
     * @param id           Identificador único del trámite.
     * @param fechaEmision Fecha de emisión del trámite.
     * @param costo        Costo del trámite.
     * @param persona      Información de la persona asociada al trámite.
     */
    public TramiteDTO(Long id, Calendar fechaEmision, Float costo, PersonaDTO persona) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     * Método para obtener el identificador único del trámite.
     *
     * @return Identificador único del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del trámite.
     *
     * @param id Identificador único del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener la fecha de emisión del trámite.
     *
     * @return Fecha de emisión del trámite.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Método para establecer la fecha de emisión del trámite.
     *
     * @param fechaEmision Fecha de emisión del trámite.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Método para obtener el costo del trámite.
     *
     * @return Costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Método para establecer el costo del trámite.
     *
     * @param costo Costo del trámite.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Método para obtener la información de la persona asociada al trámite.
     *
     * @return Información de la persona asociada al trámite.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Método para establecer la información de la persona asociada al trámite.
     *
     * @param persona Información de la persona asociada al trámite.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Método para obtener el tipo de trámite.
     *
     * @return Tipo de trámite.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para establecer el tipo de trámite.
     *
     * @param tipo Tipo de trámite.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
