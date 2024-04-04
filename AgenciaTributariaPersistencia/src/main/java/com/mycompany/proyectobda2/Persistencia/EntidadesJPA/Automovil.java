/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
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
@Entity(name = "automoviles")
@DiscriminatorValue("automovil")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Automovil extends Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Automovil() {
        super();
    }

    public Automovil(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, EstadoVehiculo estadoVehiculo, Persona persona) {
        super(serieVehiculo, marca, modelo, linea, color, estadoVehiculo, persona);
        this.id = id;

    }

    public Automovil(String serieVehiculo, String marca, String modelo, String linea, String color, EstadoVehiculo estadoVehiculo, Persona persona) {
        super(serieVehiculo, marca, modelo, linea, color, estadoVehiculo, persona);
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
        return "Automovil{" + "id=" + id + '}';
    }
}