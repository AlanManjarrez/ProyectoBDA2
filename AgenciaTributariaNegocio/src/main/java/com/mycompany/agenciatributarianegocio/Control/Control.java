/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.Control;
import com.mycompany.agenciatributariapresentacion.*;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author JESUS
 */
public class Control implements Icontrol{
    PersonaDAO personaD=new PersonaDAO();
    
    @Override
    public boolean inicioSesion(String usuario, String contraseña, Icontrol control) {
        if (usuario.equals("admin") && contraseña.equals("1234")) {
            PaginaInicio  frmInicio=new PaginaInicio(control);
            frmInicio.setVisible(true);
            JOptionPane.showMessageDialog(frmInicio, "Inicio de sesion exitoso", "!! EXITOSO ¡¡", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (!usuario.equalsIgnoreCase("admin")) {
            JOptionPane.showMessageDialog(null, "El usuario es incorrecta", "!! ALERTA ¡¡", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!contraseña.equalsIgnoreCase("1234")) {
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "!! ALERTA ¡¡", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    @Override
    public void agregaPersonas() {
        try {
            personaD.insercionPersonas();
            JOptionPane.showMessageDialog(null, "Se ha agregado 20 personas", "!! EXITOSO ¡¡", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void registrarLicencia(String rfc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
