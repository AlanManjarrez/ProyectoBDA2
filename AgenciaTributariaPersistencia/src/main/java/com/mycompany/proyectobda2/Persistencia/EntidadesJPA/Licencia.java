/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author uirtis
 */
@Entity(name = "licencias")
@DiscriminatorValue("licencia")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Licencia() {
        super();
    }

    public Licencia(Long id, Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, vigencia, personas);
        this.id = id;
    }

    public Licencia(Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, vigencia, personas);
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + '}';
    }
}
