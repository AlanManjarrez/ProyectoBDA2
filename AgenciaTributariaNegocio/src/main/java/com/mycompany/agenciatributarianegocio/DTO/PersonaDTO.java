/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.DTO;

import java.util.Calendar;

/**
 * Clase DTO de persona
 * @author JESUS
 */
public class PersonaDTO {
    
    //Atributos de la clase
    private Long id;
    private String rfc;
    private String nombres;
    private String curp;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaNacimiento;
    private String telefono;
    private boolean discapacidad;
    
    /**
     * Constructor por omisión.
     */
    public PersonaDTO() {
    }

    /**
     * Constructor con parámetros para inicializar una persona DTO.
     *
     * @param rfc              RFC de la persona.
     * @param nombres          Nombres de la persona.
     * @param apellidoPaterno  Apellido paterno de la persona.
     * @param apellidoMaterno  Apellido materno de la persona.
     * @param fechaNacimiento  Fecha de nacimiento de la persona.
     * @param telefono         Teléfono de la persona.
     * @param discapacidad     Indicador de si la persona tiene alguna discapacidad.
     * @param curp             CURP de la persona.
     */
    public PersonaDTO(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, boolean discapacidad, String curp) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.discapacidad = discapacidad;
        this.curp = curp;
    }

    /**
     * Constructor con parámetros para inicializar una persona DTO con su identificador único.
     *
     * @param id               Identificador único de la persona.
     * @param rfc              RFC de la persona.
     * @param nombres          Nombres de la persona.
     * @param apellidoPaterno  Apellido paterno de la persona.
     * @param apellidoMaterno  Apellido materno de la persona.
     * @param fechaNacimiento  Fecha de nacimiento de la persona.
     * @param telefono         Teléfono de la persona.
     * @param discapacidad     Indicador de si la persona tiene alguna discapacidad.
     * @param curp             CURP de la persona.
     */
    public PersonaDTO(Long id, String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, boolean discapacidad, String curp) {
        this.id = id;
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.discapacidad = discapacidad;
        this.curp = curp;
    }

    /**
     * Método para obtener el identificador único de la persona.
     *
     * @return Identificador único de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único de la persona.
     *
     * @param id Identificador único de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el RFC de la persona.
     *
     * @return RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Método para establecer el RFC de la persona.
     *
     * @param rfc RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método para obtener los nombres de la persona.
     *
     * @return Nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método para establecer los nombres de la persona.
     *
     * @param nombres Nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método para obtener el apellido paterno de la persona.
     *
     * @return Apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método para establecer el apellido paterno de la persona.
     *
     * @param apellidoPaterno Apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método para obtener el apellido materno de la persona.
     *
     * @return Apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    
    /**
     * Método para establecer el apellido materno de la persona
     * 
     * @param apellidoMaterno Apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método para obtener la fecha de nacimiento de la persona.
     *
     * @return Fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método para obtener el teléfono de la persona.
     *
     * @return Teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el teléfono de la persona.
     *
     * @param telefono Teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para verificar si la persona tiene alguna discapacidad.
     *
     * @return true si la persona tiene alguna discapacidad, false de lo contrario.
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     * Método para establecer si la persona tiene alguna discapacidad.
     *
     * @param discapacidad Indicador de si la persona tiene alguna discapacidad.
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Método para obtener el CURP de la persona.
     *
     * @return CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Método para establecer el CURP de la persona.
     *
     * @param curp CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }
}
