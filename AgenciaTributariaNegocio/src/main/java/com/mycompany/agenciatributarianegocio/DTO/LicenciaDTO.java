/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

import java.util.Calendar;

/**
 * Clase DTO de licencia
 * @author JESUS
 */
public class LicenciaDTO extends TramiteDTO{
    
    //Atributos de la clase
    private Calendar vigencia;

    
    /**
     * Constructor por omisión.
     */
    public LicenciaDTO() {
        super();
    }

    /**
     * Constructor con parámetros para inicializar una licencia DTO.
     *
     * @param vigencia     Fecha de vigencia de la licencia.
     * @param fechaEmision Fecha de emisión de la licencia.
     * @param costo        Costo de la licencia.
     * @param persona      Información de la persona asociada a la licencia.
     */
    public LicenciaDTO(Calendar vigencia, Calendar fechaEmision, Float costo, PersonaDTO persona) {
        super(fechaEmision, costo, persona);
        this.vigencia = vigencia;
    }

    /**
     * Constructor con parámetros para inicializar una licencia DTO con su identificador único.
     *
     * @param vigencia     Fecha de vigencia de la licencia.
     * @param id           Identificador único de la licencia.
     * @param fechaEmision Fecha de emisión de la licencia.
     * @param costo        Costo de la licencia.
     * @param persona      Información de la persona asociada a la licencia.
     */
    public LicenciaDTO(Calendar vigencia, Long id, Calendar fechaEmision, Float costo, PersonaDTO persona) {
        super(id, fechaEmision, costo, persona);
        this.vigencia = vigencia;
    }

    /**
     * Método para obtener la fecha de vigencia de la licencia.
     *
     * @return Fecha de vigencia de la licencia.
     */
    public Calendar getVigencia() {
        return vigencia;
    }

    /**
     * Método para establecer la fecha de vigencia de la licencia.
     *
     * @param vigencia Fecha de vigencia de la licencia.
     */
    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }
    
}
