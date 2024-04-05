/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

/**
 *
 * @author JESUS
 */
public class VehiculoDTO {
    private Long id;
    private String serieVehiculo;
    private String marca;
    private String modelo;
    private String linea;
    private String color;
    private String estadoVehiculo;
    private PersonaDTO persona;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String serieVehiculo, String marca, String modelo, String linea, String color, String estadoVehiculo, PersonaDTO persona) {
        this.serieVehiculo = serieVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.estadoVehiculo = estadoVehiculo;
        this.persona = persona;
    }

    public VehiculoDTO(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, String estadoVehiculo, PersonaDTO persona) {
        this.id = id;
        this.serieVehiculo = serieVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.estadoVehiculo = estadoVehiculo;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerieVehiculo() {
        return serieVehiculo;
    }

    public void setSerieVehiculo(String serieVehiculo) {
        this.serieVehiculo = serieVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
    
    
}
