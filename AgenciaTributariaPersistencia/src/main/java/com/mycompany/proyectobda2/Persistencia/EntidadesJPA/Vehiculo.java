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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    private Persona persona;

    /**
     * Constructor por omisión.
     */
    public Vehiculo() {
    }

    /**
     * Constructor con parámetros para inicializar los atributos del vehículo.
     *
     * @param serieVehiculo Número de serie del vehículo.
     * @param marca         Marca del vehículo.
     * @param modelo        Modelo del vehículo.
     * @param linea         Línea del vehículo.
     * @param color         Color del vehículo.
     * @param persona       Persona propietaria del vehículo.
     */
    public Vehiculo(String serieVehiculo, String marca, String modelo, String linea, String color, Persona persona) {
        this.serieVehiculo = serieVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.color = color;
        this.persona = persona;
    }

    /**
     * Constructor con parámetros para inicializar los atributos del vehículo.
     *
     * @param id            Identificador único del vehículo.
     * @param serieVehiculo Número de serie del vehículo.
     * @param marca         Marca del vehículo.
     * @param modelo        Modelo del vehículo.
     * @param linea         Línea del vehículo.
     * @param color         Color del vehículo.
     * @param persona       Persona propietaria del vehículo.
     */
    public Vehiculo(Long id, String serieVehiculo, String marca, String modelo, String linea, String color, Persona persona) {
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
     * @param linea La línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
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
     * Método para obtener la persona propietaria del vehículo.
     *
     * @return La persona propietaria del vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método para establecer la persona propietaria del vehículo.
     *
     * @param persona La persona propietaria del vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Método toString que retorna una representación en String del objeto Vehiculo.
     *
     * @return La representación en String del objeto Vehiculo.
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", serieVehiculo=" + serieVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", linea=" + linea + ", color=" + color + ", persona=" + persona + '}';
    }
}
