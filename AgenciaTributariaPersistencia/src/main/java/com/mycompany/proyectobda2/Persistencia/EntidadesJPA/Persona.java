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
 * Clase JPA para persona
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
    
    /**
     * Constructor por omisión
     */
    public Persona() {
    }
    
    /**
     * Constructor con todos los parámetros
     * @param RFC             RFC de la persona
     * @param CURP            CURP de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param telefono        Teléfono de la persona
     * @param nombre          Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param discapacidad    Indica si la persona tiene alguna discapacidad
     */
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
    
    /**
     * Constructor con todos los parámetros, incluido el identificador
     * 
     * @param id              Identificador de la persona
     * @param RFC             RFC de la persona
     * @param CURP            CURP de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param telefono        Teléfono de la persona
     * @param nombre          Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param discapacidad    Indica si la persona tiene alguna discapacidad
     */
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

    /**
     * Método para obtener el identificador de la persona
     * 
     * @return El identificador de la persona
     */
    public Long getId() {
        return id;
    }
    
   /**
     * Método para establecer el identificador de la persona
     * 
     * @param id El identificador de la persona
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el RFC de la persona
     * 
     * @return El RFC de la persona
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Método para establecer el RFC de la persona
     * 
     * @param RFC  El RFC de la persona
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Método para obtener la curp de la persona
     * 
     * @return La curp de la persona
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * Método para establecer la curp de la persona
     * 
     * @param CURP  la curp de la persona
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * Método para obtener la fecha de nacimiento de la persona
     * 
     * @return La fecha de nacimiento de la persona
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento de la persona
     * 
     * @param fechaNacimiento  La fecha de naciemiento de la persona
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método para obtener el telefono de la persona
     * 
     * @return El telefono de la persona
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el telefono de la persona
     * 
     * @param telefono  El telefonode la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el nombre de la persona
     * 
     * @return El nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de la persona
     * 
     * @param nombre El nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el apellido paterno de la persona
     * 
     * @return El apellido paterno 
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método para establecer el apellido paterno de la persona
     * 
     * @param apellidoPaterno apellido paterno de la persona
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método para obtener el apellido materno de la persona
     * 
     * @return el apellido materno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método para establecer el apellido materno de la persona
     * 
     * @param apellidoMaterno apellido materno de la persona
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    /**
     * Método para obtener si la persona tiene discapacidad
     * 
     * @return boolano si la persona cuenta con discapacidad
     */
    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Método para establecer si la persona cuenta con alguna discapacidad
     * 
     * @param discapacidad  discapacidad de la persona
     */
    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", RFC=" + RFC + ", CURP=" + CURP + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", discapacidad=" + discapacidad + '}';
    }


}
