/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

/**
 *  Clase DTO vehiculo
 * @author JESUS
 */
public class VehiculoDTO {
    
    //Atributos de la clase
    private Long id;
    private String serieVehiculo;
    private String marca;
    private String modelo;
    private String linea;
    private String color;
    private PersonaDTO persona;

    /**
     * Constructor por omisión.
     */
    public VehiculoDTO() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param serieVehiculo Número de serie del vehículo.
     * @param marca         Marca del vehículo.
     * @param modelo        Modelo del vehículo.
     * @param linea         Línea del vehículo.
     * @param color         Color del vehículo.
     * @param persona       Información de la persona propietaria del vehículo.
     */
    public VehiculoDTO(String serieVehiculo, String marca, String modelo, String linea, String color, PersonaDTO persona) {
        this.serieVehiculo = serieVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
    }

    /**
     * Constructor con todos los atributos, incluyendo el identificador único.
     *
     * @param id            Identificador único del vehículo.
     * @param serieVehiculo Número de serie del vehículo.
     * @param marca         Marca del vehículo.
     * @param modelo        Modelo del vehículo.
     * @param linea         Línea del vehículo.
     * @param color         Color del vehículo.
     * @param persona       Información de la persona propietaria del vehículo.
     */
    public VehiculoDTO(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, PersonaDTO persona) {
        this.id = id;
        this.serieVehiculo = serieVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
    }
    
     /**
     * Método para obtener el identificador único del vehículo.
     *
     * @return El identificador único del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del vehículo.
     *
     * @param id El identificador único del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el número de serie del vehículo.
     *
     * @return El número de serie del vehículo.
     */
    public String getSerieVehiculo() {
        return serieVehiculo;
    }

    /**
     * Método para establecer el número de serie del vehículo.
     *
     * @param serieVehiculo El número de serie del vehículo.
     */
    public void setSerieVehiculo(String serieVehiculo) {
        this.serieVehiculo = serieVehiculo;
    }

    /**
     * Método para obtener la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método para establecer la marca del vehículo.
     *
     * @param marca La marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para obtener el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método para establecer el modelo del vehículo.
     *
     * @param modelo El modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método para obtener la línea del vehículo.
     *
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }
    
    /**
     * Método para establecer la línea del vehículo.
     *
     * @param linea La línea del vehiculo
     */
    public void setLinea(String linea){
        this.linea=linea;
    }
    
    /**
     * Método para obtener el color del vehículo.
     *
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Método para establecer el color del vehículo.
     *
     * @param color El color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método para obtener la información de la persona propietaria del vehículo.
     *
     * @return La información de la persona propietaria del vehículo.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Método para establecer la información de la persona propietaria del vehículo.
     *
     * @param persona La información de la persona propietaria del vehículo.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }
}
