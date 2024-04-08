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
public class LicenciaDTO extends TramiteDTO{
    private Long id;
    private Calendar vigencia;

    public LicenciaDTO() {
        super();
    }

    public LicenciaDTO(Long id, Calendar fechaEmision, Float costo, Calendar vigencia, PersonaDTO persona) {
        super(fechaEmision, costo,  persona);
        this.id = id;
        this.vigencia=vigencia;
    }

    public LicenciaDTO(Calendar fechaEmision, Float costo, Calendar vigencia, PersonaDTO persona) {
        super(fechaEmision, costo,  persona);
        this.vigencia=vigencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }
    
    
}
