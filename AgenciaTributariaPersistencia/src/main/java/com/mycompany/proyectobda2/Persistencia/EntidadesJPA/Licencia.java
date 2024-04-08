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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author uirtis
 */
@Entity
@DiscriminatorValue("licencia")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "vigencia", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar vigencia;
    
    public Licencia() {
        super();
    }

    public Licencia(Long id, Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, personas);
        this.id = id;
        this.vigencia=vigencia;
    }

    public Licencia(Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, personas);
        this.vigencia=vigencia;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

    
    
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + '}';
    }
}
