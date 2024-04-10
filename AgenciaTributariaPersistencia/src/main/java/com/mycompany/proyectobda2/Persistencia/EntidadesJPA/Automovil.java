/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Clase JPA para automoviles
 * @author uirtis
 */
@Entity
@DiscriminatorValue("automovil")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Automovil extends Vehiculo implements Serializable {
    
    /**
     * Constructor por omision
     */
    public Automovil() {
        super();
    }
    
    /**
     * Constructor con todos los parámetros
     * 
     * @param id Identificador del automóvil
     * @param serieVehiculo Serie del vehículo
     * @param marca Marca del automóvil
     * @param modelo Modelo del automóvil
     * @param linea Línea del automóvil
     * @param color Color del automóvil
     * @param persona Persona asociada al automóvil
     */
    public Automovil(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, Persona persona) {
        super(id,serieVehiculo, marca, modelo, linea, color,  persona);// Llama al constructor de la clase base (Vehiculo)

    }
    
    /**
     * Constructor sin el parámetro "id"
     * 
     * @param serieVehiculo Serie del vehículo
     * @param marca Marca del automóvil
     * @param modelo Modelo del automóvil
     * @param linea Línea del automóvil
     * @param color Color del automóvil
     * @param persona Persona asociada al automóvil
     */
    public Automovil(String serieVehiculo, String marca, String modelo, String linea, String color, Persona persona) {
        super(serieVehiculo, marca, modelo, linea, color, persona);// Llama al constructor de la clase base (Vehiculo)
    }
    
    /**
     * Método para obtener una representación de cadena del objeto Automovil
     */
    @Override
    public String toString() {
        return "Automovil{" + "id=" + getId() + '}';
    }
    
}