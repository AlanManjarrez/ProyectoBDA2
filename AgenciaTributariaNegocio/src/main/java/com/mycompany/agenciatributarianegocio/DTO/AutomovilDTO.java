/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

/**
 *
 * @author JESUS
 */
public class AutomovilDTO extends VehiculoDTO{
    private Long id;

    public AutomovilDTO() {
        super();
    }

    public AutomovilDTO(String serieVehiculo, String marca, String modelo, String linea, String color, PersonaDTO persona) {
        super(serieVehiculo, marca, modelo, linea, color, persona);
    }

    public AutomovilDTO(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, PersonaDTO persona) {
        super(id, serieVehiculo, marca, modelo, linea, color, persona);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AutomovilDTO{" + "id=" + id + '}';
    }
    
    
}
