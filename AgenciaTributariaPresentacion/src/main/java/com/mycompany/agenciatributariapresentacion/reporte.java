/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributariapresentacion;

import java.util.Date;

/**
 *
 * @author JESUS
 */
public class reporte {
    private String tipo;
    private String nombre;
    private String fechaEmision;
    private String costo;

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCosto() {
        return costo;
    }

    public reporte() {
    }

    public reporte(String tipo, String nombre, String fechaEmision, String costo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
    }
    
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
}
