/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.EntidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author uirtis
 */
@Entity(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RFC", nullable = false, length = 13)
    private String RFC;

    @Column(name = "CURP", nullable = false, length = 20)
    private String CURP;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 150)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 150)
    private String apellidoMaterno;

    @Column(name = "discapacidad", nullable = false)
    private Boolean discapacidad;

    public Persona() {
    }

    public Persona(String RFC, String CURP, Calendar fechaNacimiento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Boolean discapacidad) {
        this.RFC = RFC;
        this.CURP = CURP;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.discapacidad = discapacidad;
    }

    public Persona(Long id, String RFC, String CURP, Calendar fechaNacimiento, String telefono, String nombre, String apellidoPaterno, String apellidoMaterno, Boolean discapacidad) {
        this.id = id;
        this.RFC = RFC;
        this.CURP = CURP;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.discapacidad = discapacidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", RFC=" + RFC + ", CURP=" + CURP + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", discapacidad=" + discapacidad + '}';
    }

}
