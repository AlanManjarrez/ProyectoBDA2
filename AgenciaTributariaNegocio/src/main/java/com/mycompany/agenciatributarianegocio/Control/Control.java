/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.Control;
import com.mycompany.agenciatributarianegocio.DTO.LicenciaDTO;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributariapresentacion.*;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.TramiteDAO;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author JESUS
 */
public class Control implements Icontrol{
    PersonaDAO personaD=new PersonaDAO();
    TramiteDAO tramiteD=new TramiteDAO();
    PersonaDTO per;
    
    @Override
    public boolean inicioSesion(String usuario, String contraseña, Icontrol control) {
        if (usuario.equals("admin") && contraseña.equals("1234")) {
            PaginaInicio  frmInicio=new PaginaInicio(control);
            frmInicio.setVisible(true);
            JOptionPane.showMessageDialog(frmInicio, "Inicio de sesion exitoso", "!! EXITOSO ¡¡", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (!usuario.equals("admin")) {
            JOptionPane.showMessageDialog(null, "El usuario es incorrecta", "!! ALERTA ¡¡", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!contraseña.equals("1234")) {
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
    public PersonaDTO buscarLicencia(String rfc) {
        per=new PersonaDTO();
        per=personaD.consultarPersonaRFC(rfc);
        if (per!=null) {
          return per;  
        }else{
            JOptionPane.showMessageDialog(null, "No existe persona con ese rfc");
            return null;
        }
    }    

    @Override
    public void altaLicencia(PersonaDTO persona,Float costo,Calendar vigencia) {
        try {
            Calendar fecha= Calendar.getInstance();
            LicenciaDTO licencia =new LicenciaDTO(fecha, costo, vigencia, persona);
            tramiteD.agregarTramite(licencia);
            JOptionPane.showMessageDialog(null, "Se ha dado de alta la licencia");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean verificarLicencia(String rfc) {
        try {
            if (tramiteD.verificarLicencia(rfc)) {
                JOptionPane.showMessageDialog(null, "Esta persona ya cuenta con licencia","!! ADVERTENCIA ¡¡",JOptionPane.WARNING_MESSAGE);
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error al verificar la licencia: " + e.getMessage());
        }
        return false;
        
    }
    
    
    
    
    
}
