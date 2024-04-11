/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributariapresentacion;

import java.util.regex.Pattern;

/**
 *
 * @author JESUS
 */
public class validadores {
    
    public boolean validarFecha(String fecha) {
        String patronFecha = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])";
        return Pattern.matches(patronFecha, fecha);
    }
    
    public boolean validarLetras(String texto) {
        String patronLetrasNumeros = "^[a-zA-Z0-9]{1,8}$";
        return Pattern.matches(patronLetrasNumeros, texto);
    }
    
     public boolean validarRFC(String rfc) {
        String patronRFC = "^[a-zA-Z0-9]{1,13}$";
        return Pattern.matches(patronRFC, rfc);
    }
}
