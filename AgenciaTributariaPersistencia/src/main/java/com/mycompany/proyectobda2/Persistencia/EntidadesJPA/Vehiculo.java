/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author uirtis
 */
@Entity(name = "vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serie_vehiculo", nullable = true, length = 17)
    private String serieVehiculo;

    @Column(name = "marca", nullable = true, length = 50)
    private String marca;

    @Column(name = "modelo", nullable = true, length = 100)
    private String modelo;

    @Column(name = "linea", nullable = true, length = 100)
    private String linea;

    @Column(name = "color", nullable = true, length = 100)
    private String color;

    @Column(name = "estado", nullable = true)
    private EstadoVehiculo estadoVehiculo;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(String serieVehiculo, String marca, String modelo, String linea, String color, EstadoVehiculo estadoVehiculo, Persona persona) {
        this.serieVehiculo = serieVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.estadoVehiculo = estadoVehiculo;
        this.persona = persona;
    }

    public Vehiculo(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, EstadoVehiculo estadoVehiculo, Persona persona) {
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

    public EstadoVehiculo getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
