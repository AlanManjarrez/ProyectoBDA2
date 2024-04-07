/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.Control;

import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import java.util.Calendar;


/**
 *
 * @author JESUS
 */
public interface Icontrol {
    
    public boolean inicioSesion(String usuario, String contraseña, Icontrol control);

    public void agregaPersonas();

    public PersonaDTO buscarLicencia(String rfc);
    
    public void altaLicencia(PersonaDTO persona,Float costo,Calendar vigencia);
    
    public boolean verificarLicencia(String rfc);
    
    public void agregaVehiculo(VehiculoDTO vehiculo);
}
