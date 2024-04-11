/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.control;

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
    /**
     * Metodo para iniciar sesion con contraseña y usuario ya establecido
     * @param usuario usuario para iniciar sesion
     * @param contraseña contraseña para iniciar sesion
     * @return true si son iguales
     */
    public boolean iniciarSesion(String usuario,String contraseña);
    
    /**
     * Metodo para agregar automaticamente a las personas
     */
    public void agregarPersonas();
    
    /**
     * Metodo que busca a la persona por su rfc
     * @param rfc rfc de la persona
     * @return a la persona si la encuentra
     */
    public PersonaDTO buscarLicencia(String rfc);
    
    
    public void darAltaLicencia(PersonaDTO persona,Float costo, Calendar vigencia);
    
    
    public boolean verificarLicencia(String rfc);
    
    
    public VehiculoDTO agregarVehiculo(VehiculoDTO vehiculo);
    
    
    public List<VehiculoDTO> obtenerVehiculos(PersonaDTO persona);
    
    
    public void darAltaPlaca(PersonaDTO persona,Float costo,Calendar recepcion,VehiculoDTO vehiculo);
    
    
    public String[] obtenerPersonas(int tipo);
    
    
    public List<TramiteDTO> consultarTramites(String opcion,int tipo,PersonaDTO persona);
    
    
    public List<PersonaDTO> consultaEspecificaPersonas(String opcion,int tipo);
    
    
   public List<TramiteDTO> consultaEspecificaTipoPeriodo(String tipoT,int tipo,Calendar fechaI, Calendar fechaF);
   
}
