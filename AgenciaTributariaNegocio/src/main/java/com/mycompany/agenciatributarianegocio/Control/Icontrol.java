/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.Control;

import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import java.util.Calendar;
import java.util.List;


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
    
    public List<VehiculoDTO> obtenerVehiculos(PersonaDTO persona);
    
    public void altaPlaca(PersonaDTO persona,Float costo,Calendar recepcion,VehiculoDTO vehiculo);
    
    public String[] obtenerPersonas(int tipo);
        
    public List<TramiteDTO> consultarTramites(String opcion,int tipo,PersonaDTO persona);

    public List<PersonaDTO> consultaEspecificaPersonas(String opcion,int tipo);
}
