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

    public LicenciaDTO() {
        super();
    }

    public LicenciaDTO(Long id, Calendar fechaEmision, Float costo, Calendar vigencia, PersonaDTO persona) {
        super(fechaEmision, costo, vigencia, persona);
        this.id = id;
    }

    public LicenciaDTO(Calendar fechaEmision, Float costo, Calendar vigencia, PersonaDTO persona) {
        super(fechaEmision, costo, vigencia, persona);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
