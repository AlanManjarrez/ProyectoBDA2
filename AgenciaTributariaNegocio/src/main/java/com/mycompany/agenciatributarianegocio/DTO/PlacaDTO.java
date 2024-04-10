/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

import java.util.Calendar;

/**
 * clase DTO de placa
 * @author JESUS
 */
public class PlacaDTO extends TramiteDTO{
    
    //Atributos de la clase
    private Calendar fechaRecepcion;
    private String seriePlacas;
    private String estadoPlacas;
    private VehiculoDTO vehiculo;

    /**
     * Constructor por omisión.
     */
    public PlacaDTO() {
        super();
    }

    /**
     * Constructor con parámetros para inicializar una placa DTO.
     *
     * @param fechaRecepcion Fecha de recepción de la placa.
     * @param seriePlacas    Serie de la placa.
     * @param estadoPlacas   Estado de la placa.
     * @param vehiculo       Información del vehículo asociado a la placa.
     * @param fechaEmision   Fecha de emisión del trámite.
     * @param costo          Costo del trámite.
     * @param persona        Información de la persona asociada al trámite.
     */
    public PlacaDTO(Calendar fechaRecepcion, String seriePlacas, String estadoPlacas, VehiculoDTO vehiculo, Calendar fechaEmision, Float costo, PersonaDTO persona) {
        super(fechaEmision, costo, persona);
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.estadoPlacas = estadoPlacas;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor con parámetros para inicializar una placa DTO con su identificador único.
     *
     * @param id             Identificador único de la placa.
     * @param fechaRecepcion Fecha de recepción de la placa.
     * @param seriePlacas    Serie de la placa.
     * @param estadoPlacas   Estado de la placa.
     * @param vehiculo       Información del vehículo asociado a la placa.
     * @param fechaEmision   Fecha de emisión del trámite.
     * @param costo          Costo del trámite.
     * @param persona        Información de la persona asociada al trámite.
     */
    public PlacaDTO(Long id, Calendar fechaRecepcion, String seriePlacas, String estadoPlacas, VehiculoDTO vehiculo, Calendar fechaEmision, Float costo, PersonaDTO persona) {
        super(id, fechaEmision, costo, persona);
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.estadoPlacas = estadoPlacas;
        this.vehiculo = vehiculo;
    }

    /**
     * Método para obtener la fecha de recepción de la placa.
     *
     * @return Fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Método para establecer la fecha de recepción de la placa.
     *
     * @param fechaRecepcion Fecha de recepción de la placa.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Método para obtener la serie de la placa.
     *
     * @return Serie de la placa.
     */
    public String getSeriePlacas() {
        return seriePlacas;
    }

    /**
     * Método para establecer la serie de la placa.
     *
     * @param seriePlacas Serie de la placa.
     */
    public void setSeriePlacas(String seriePlacas) {
        this.seriePlacas = seriePlacas;
    }

    /**
     * Método para obtener el estado de la placa.
     *
     * @return Estado de la placa.
     */
    public String getEstadoPlacas() {
        return estadoPlacas;
    }

    /**
     * Método para establecer el estado de la placa.
     *
     * @param estadoPlacas Estado de la placa.
     */
    public void setEstadoPlacas(String estadoPlacas) {
        this.estadoPlacas = estadoPlacas;
    }

    /**
     * Método para obtener la información del vehículo asociado a la placa.
     *
     * @return Información del vehículo asociado a la placa.
     */
    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     * Método para establecer la información del vehículo asociado a la placa.
     *
     * @param vehiculo Información del vehículo asociado a la placa.
     */
    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
