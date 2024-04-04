/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author uirtis
 */
@Entity(name = "placas")
@DiscriminatorValue("placa")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Placa extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    @Column(name = "serie_placas", nullable = false)
    private String seriePlacas;

    @Column(name = "estado_placa", nullable = false)
    private EstadoPlaca estadoPlaca;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id")
    private Vehiculo vehiculo;

    public Placa() {
        super();
    }

    public Placa(Calendar fechaRecepcion, String seriePlacas, EstadoPlaca estadoPlaca, Vehiculo vehiculo, Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, vigencia, personas);
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.estadoPlaca = estadoPlaca;
        this.vehiculo = vehiculo;
    }

    public Placa(Long id, Calendar fechaRecepcion, String seriePlacas, Vehiculo vehiculo, EstadoPlaca estadoPlaca, Calendar fechaEmision, Float costo, Calendar vigencia, Persona personas) {
        super(fechaEmision, costo, vigencia, personas);
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.estadoPlaca = estadoPlaca;
        this.vehiculo = vehiculo;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public EstadoPlaca getEstadoPlaca() {
        return estadoPlaca;
    }

    public void setEstadoPlaca(EstadoPlaca estadoPlaca) {
        this.estadoPlaca = estadoPlaca;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", fechaRecepcion=" + fechaRecepcion + ", seriePlacas=" + seriePlacas + ", estadoPlaca=" + estadoPlaca + ", vehiculo=" + vehiculo + '}';
    }
}
