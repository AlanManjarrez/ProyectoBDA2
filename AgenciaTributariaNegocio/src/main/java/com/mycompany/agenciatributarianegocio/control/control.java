/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.control;

import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS
 */
public class control implements Icontrol{

    //Varibles
    PersonaDAO personaD=new PersonaDAO();
    
    
    /**
     * Metodo para iniciar sesion con contraseña y usuario ya establecido
     * @param usuario usuario para iniciar sesion
     * @param contraseña contraseña para iniciar sesion
     * @return true si son iguales
     */
    @Override
    public boolean iniciarSesion(String usuario, String contraseña) {
        if (usuario.equals("admin") && contraseña.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso"," !! BIENVENIDO !!!",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }else if (!usuario.equals("admin")) {
            JOptionPane.showMessageDialog(null, "Usuario incorrecto"," !! ALERTA !!!",JOptionPane.WARNING_MESSAGE);
            return false;
        }else if (!contraseña.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta"," !! ALERTA !!!",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return false;
        
    }

    @Override
    public void agregarPersonas() {
        try {
            personaD.insercionPersonas();
            JOptionPane.showMessageDialog(null, "Se han agregado 20 personas");
        } catch (Exception e) {
            System.out.println("Fallo al agregar las 20 personas "+e.getMessage());
        }
    }

    @Override
    public PersonaDTO buscarLicencia(String rfc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void darAltaLicencia(PersonaDTO persona, Float costo, Calendar vigencia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean verificarLicencia(String rfc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarVehiculo(VehiculoDTO vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculos(PersonaDTO persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void darAltaPlaca(PersonaDTO persona, Float costo, Calendar recepcion, VehiculoDTO vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] obtenerPersonas(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TramiteDTO> consultarTramites(String opcion, int tipo, PersonaDTO persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PersonaDTO> consultaEspecificaPersonas(String opcion, int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TramiteDTO> consultaEspecificaTipoPeriodo(String tipoT, int tipo, Calendar fechaI, Calendar fechaF) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
