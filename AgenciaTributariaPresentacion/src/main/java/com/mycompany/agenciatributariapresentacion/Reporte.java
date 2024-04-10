/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributariapresentacion;

/**
 * Clase heca para el funcionamiento de jasper reports
 * @author JESUS
 */
public class Reporte {
    //Atributos
    private String tipo;
    private String nombre;
    private String fechaEmision;
    private String costo;

    /**
     * Constructor por omision
     */
    public Reporte() {
    }

    /**
     * Constructor con todos lo atributos
     * @param tipo tipo de tramite
     * @param nombre nombre de la persona
     * @param fechaEmision fecha del tramite realizado
     * @param costo costo del tramite
     */
    public Reporte(String tipo, String nombre, String fechaEmision, String costo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
    }

    /**
     * Método para obtener el tipo de trámite del reporte.
     *
     * @return El tipo de trámite del reporte.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método para establecer el tipo de trámite del reporte.
     *
     * @param tipo El tipo de trámite del reporte.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para obtener el nombre de la persona asociada al reporte.
     *
     * @return El nombre de la persona asociada al reporte.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de la persona asociada al reporte.
     *
     * @param nombre El nombre de la persona asociada al reporte.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la fecha de emisión del reporte.
     *
     * @return La fecha de emisión del reporte.
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Método para establecer la fecha de emisión del reporte.
     *
     * @param fechaEmision La fecha de emisión del reporte.
     */
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Método para obtener el costo del trámite asociado al reporte.
     *
     * @return El costo del trámite asociado al reporte.
     */
    public String getCosto() {
        return costo;
    }

    /**
     * Método para establecer el costo del trámite asociado al reporte.
     *
     * @param costo El costo del trámite asociado al reporte.
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }
    
    
    
}
