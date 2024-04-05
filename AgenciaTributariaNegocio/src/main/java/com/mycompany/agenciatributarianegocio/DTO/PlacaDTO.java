/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

import java.util.Calendar;

/**
 *
 * @author JESUS
 */
public class PlacaDTO extends TramiteDTO{
    private Long id;
    private Calendar fechaRecepcion;
    private String seriePlacas;
    private String estadoPlacas;
    private VehiculoDTO vehiculo;

    public PlacaDTO() {
        super();
    }

    public PlacaDTO(Calendar fechaRecepcion, String seriePlacas, String estadoPlacas, VehiculoDTO vehiculo, Calendar fechaEmision, Float costo, Calendar vigencia, PersonaDTO persona) {
        super(fechaEmision, costo, vigencia, persona);
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.estadoPlacas = estadoPlacas;
        this.vehiculo = vehiculo;
    }

    public PlacaDTO(Long id,Calendar fechaRecepcion, String seriePlacas, String estadoPlacas, VehiculoDTO vehiculo, Calendar fechaEmision, Float costo, Calendar vigencia, PersonaDTO persona) {
        super(id, fechaEmision, costo, vigencia, persona);
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.estadoPlacas = estadoPlacas;
        this.vehiculo = vehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getSeriePlacas() {
        return seriePlacas;
    }

    public void setSeriePlacas(String seriePlacas) {
        this.seriePlacas = seriePlacas;
    }

    public String getEstadoPlacas() {
        return estadoPlacas;
    }

    public void setEstadoPlacas(String estadoPlacas) {
        this.estadoPlacas = estadoPlacas;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    
    
   
}
