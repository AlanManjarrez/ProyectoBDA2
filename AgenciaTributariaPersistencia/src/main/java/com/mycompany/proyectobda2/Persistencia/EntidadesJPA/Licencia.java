/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *  Clase JPA para la licencias
 * @author uirtis
 */
@Entity
@DiscriminatorValue("licencia")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Licencia extends Tramite implements Serializable {
    
    // Tipo de temporalidad de la columna "vigencia"
    // Columna "vigencia" en la base de datos
    @Column (name = "vigencia", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar vigencia;
    
    /**
     * Constructor por omisión
     */
    public Licencia() {
        super();// Llama al constructor de la clase base (Tramite)
    }

    /**
     * Constructor con todos los parámetros
     * 
     * @param id Identificador de la licencia
     * @param fechaEmision Fecha de emisión de la licencia
     * @param costo Costo de la licencia
     * @param vigencia Fecha de vigencia de la licencia
     * @param personas Persona asociada a la licencia
     */
    public Licencia(Long id, Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(id,fechaEmision, costo, personas);// Llama al constructor de la clase base (Tramite)
        this.vigencia=vigencia;
    }

    /**
     * Constructor sin el parámetro "id"
     * 
     * @param fechaEmision Fecha de emisión de la licencia
     * @param costo Costo de la licencia
     * @param vigencia Fecha de vigencia de la licencia
     * @param personas Persona asociada a la licencia
     */
    public Licencia(Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, personas);// Llama al constructor de la clase base (Tramite)
        this.vigencia=vigencia;
    }
    
    /**
     * Método getter para obtener la vigencia de la licencia
     * 
     * @return La fecha de vigencia de la licencia
     */
    public Calendar getVigencia() {
        return vigencia;
    }

    /**
     * Método setter para establecer la vigencia de la licencia
     * 
     * @param vigencia La fecha de vigencia de la licencia
     */
    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

}
