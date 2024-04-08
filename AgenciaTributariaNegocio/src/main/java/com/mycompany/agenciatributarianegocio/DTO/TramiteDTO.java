/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

import java.util.Calendar;

/**
 *
 * @author JESUS
 */
public class TramiteDTO {
    private Long id;
    private Calendar fechaEmision;
    private Float costo;
    private PersonaDTO persona;

    public TramiteDTO() {
    }

    public TramiteDTO(Calendar fechaEmision, Float costo, PersonaDTO persona) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        
        this.persona = persona;
    }

    public TramiteDTO(Long id, Calendar fechaEmision, Float costo, PersonaDTO persona) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
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

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
    
    
    
}
