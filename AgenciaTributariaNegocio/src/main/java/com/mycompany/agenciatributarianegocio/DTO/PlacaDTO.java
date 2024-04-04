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
public class PlacaDTO {
    private Integer id;
    private Double costo;
    private Calendar vigencia;
    private Calendar fechaEmision;
    private Calendar fechaRecepcion;
    private String seriePlacas;

    public PlacaDTO() {
    }

    public PlacaDTO(Double costo, Calendar vigencia, Calendar fechaEmision, Calendar fechaRecepcion, String seriePlacas) {
        this.costo = costo;
        this.vigencia = vigencia;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
    }

    public PlacaDTO(Integer id, Double costo, Calendar vigencia, Calendar fechaEmision, Calendar fechaRecepcion, String seriePlacas) {
        this.id = id;
        this.costo = costo;
        this.vigencia = vigencia;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
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
}
