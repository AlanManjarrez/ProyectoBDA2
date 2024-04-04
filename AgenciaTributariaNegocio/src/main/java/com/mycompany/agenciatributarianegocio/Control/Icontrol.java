/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.Control;

import javax.swing.JFrame;

/**
 *
 * @author JESUS
 */
public interface Icontrol {
    
    public boolean inicioSesion(String usuario, String contraseña, Icontrol control);

    public void agregaPersonas();

    public void registrarLicencia(String rfc);
}
