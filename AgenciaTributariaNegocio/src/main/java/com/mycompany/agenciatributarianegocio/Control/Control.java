/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.Control;
import com.mycompany.agenciatributarianegocio.DTO.AutomovilDTO;
import com.mycompany.agenciatributarianegocio.DTO.LicenciaDTO;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.PlacaDTO;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import com.mycompany.agenciatributariapresentacion.*;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.TramiteDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.VehiculoDAO;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author JESUS
 */
public class Control implements Icontrol{
    PersonaDAO personaD=new PersonaDAO();
    TramiteDAO tramiteD=new TramiteDAO();
    VehiculoDAO vehiculoD=new VehiculoDAO();
    PersonaDTO per;
    String[] listas;
    
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
            System.out.println("Error al generar licencia"+e.getMessage());
        }
    }

    @Override
    public boolean verificarLicencia(String rfc) {
        try {
            if (tramiteD.verificarLicencia(rfc)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la licencia: " + e.getMessage());
        }
        return false;
        
    }

    @Override
    public void agregaVehiculo(VehiculoDTO vehiculo) {
        try {
            vehiculoD.agregarVehiculo(vehiculo);
            JOptionPane.showMessageDialog(null, "Se ha agregado el vehiculo");
        } catch (Exception e) {
            System.out.println("Error al agregar vehiculo: "+ e.getMessage());
        }
    }

    @Override
    public List<VehiculoDTO> obtenerVehiculos(PersonaDTO persona) {
        try {
            List<VehiculoDTO> vehiculos=vehiculoD.consultarTodoVehiculo(persona); 
            return vehiculos;
        } catch (Exception e) {
            System.out.println("Error al regresar lista de vehiculos: "+e.getMessage());
        }
        return null;
    }

    @Override
    public void altaPlaca(PersonaDTO persona, Float costo, Calendar recepcion, VehiculoDTO vehiculo) {
        try {
            Calendar recepci=recepcion;
            String serie=tramiteD.generarSerie();
            PlacaDTO placa=new PlacaDTO(recepcion,serie , "ACTIVO", vehiculo, recepcion, costo, persona);
            tramiteD.agregarTramite(placa);
            JOptionPane.showMessageDialog(null, "Se ha dado de alta la placa con numero de serie "+serie);
        } catch (Exception e) {
            System.out.println("Error al generar la placa"+e.getMessage());
        }
    }

    @Override
    public String[] consultaPersonas(int tipo) {
        
        try {
            
            List<PersonaDTO> personas = personaD.consultaPersonas();
            String[] lista = new String[personas.size()];
            listas = new String[personas.size()];
            
            if (tipo==1) {
                for (int i = 0; i < personas.size(); i++) {
                    PersonaDTO persona= personas.get(i);
                    listas[i] = persona.getId()+ " " + persona.getCurp();
                    lista[i]=persona.getCurp();
                }
            }else if (tipo==2) {
                for (int i = 0; i < personas.size(); i++) {
                    PersonaDTO persona = personas.get(i);
                    String nombreCompleto = persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
                    listas[i] = persona.getId()+ " " + nombreCompleto;
                    lista[i]=nombreCompleto;
                }
            }else if (tipo==3) {
                for (int i = 0; i < personas.size(); i++) {
                    PersonaDTO persona = personas.get(i);
                    Calendar fechaNacimiento = persona.getFechaNacimiento();
                    int año = fechaNacimiento.get(Calendar.YEAR);
                    listas[i] = persona.getId() + " " + año;
                    lista[i] = String.valueOf(año);
                }
            }
            
            
            return lista;
        } catch (Exception e) {
            System.out.println("Error al consultar todas las personas"+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<TramiteDTO> consultarTramites(String opcion, int tipo) {
        try {
            List<TramiteDTO> tramites=new ArrayList<>();
            if (tipo==1) {
                tramites= tramiteD.buscarPorCurp(opcion);
            }else if (tipo==2) {
                
            }else if (tipo==3) {
                
            }
            return tramites;
        } catch (Exception e) {
            System.out.println("Error al consultar los tramites");
        }
        return null;
    }
    
    
    
    
    
    
    
    
}
