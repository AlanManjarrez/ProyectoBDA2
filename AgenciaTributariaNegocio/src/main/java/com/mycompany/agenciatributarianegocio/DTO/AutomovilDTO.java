/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

/**
 *  Clase DTO de automovil
 * @author JESUS
 */
public class AutomovilDTO extends VehiculoDTO{
    private Long id;
   /**
     * Constructor por omisión.
     */
    public AutomovilDTO() {
        super();
    }

    /**
     * Constructor con parámetros para inicializar un automóvil DTO.
     *
     * @param serieVehiculo Serie del vehículo.
     * @param marca         Marca del vehículo.
     * @param modelo        Modelo del vehículo.
     * @param linea         Línea del vehículo.
     * @param color         Color del vehículo.
     * @param persona       Información de la persona propietaria del vehículo.
     */
    public AutomovilDTO(String serieVehiculo, String marca, String modelo, String linea, String color, PersonaDTO persona) {
        super(serieVehiculo, marca, modelo, linea, color, persona);
        
    }

    /**
     * Constructor con parámetros para inicializar un automóvil DTO con su identificador único.
     *
     * @param id            Identificador único del automóvil.
     * @param serieVehiculo Serie del vehículo.
     * @param marca         Marca del vehículo.
     * @param modelo        Modelo del vehículo.
     * @param linea         Línea del vehículo.
     * @param color         Color del vehículo.
     * @param persona       Información de la persona propietaria del vehículo.
     */
    public AutomovilDTO(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, PersonaDTO persona) {
        super(id, serieVehiculo, marca, modelo, linea, color, persona);
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
