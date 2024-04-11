/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenciatributarianegocio.control;

import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import com.mycompany.proyectobda2.Persistencia.DAOS.IPersonaDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.ITramiteDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.Ivehiculo;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.TramiteDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.VehiculoDAO;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.EstadoPlaca;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Licencia;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Placa;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Tramite;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS
 */
public class control implements Icontrol{

    //Varibles
    IPersonaDAO personaD=new PersonaDAO();
    ITramiteDAO tramiteD=new TramiteDAO();
    VehiculoDAO vehiculoD=new VehiculoDAO();
    
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
    
    /**
     * Metodo para agregar automaticamente a las personas
     */
    @Override
    public void agregarPersonas() {
        try {
            personaD.insercionPersonas();
            JOptionPane.showMessageDialog(null, "Se han agregado 20 personas");
        } catch (Exception e) {
            System.out.println("Fallo al agregar las 20 personas "+e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido agregar a las personas");
        }
    }
    
    /**
     * Metodo que busca a la persona por su rfc
     * @param rfc rfc de la persona
     * @return a la persona si la encuentra
     */
    @Override
    public PersonaDTO buscarLicencia(String rfc) {
        Persona personaConRFC = new Persona();
        personaConRFC.setRFC(rfc);
    
        try {
            Persona persona = personaD.consultarPersonaRFC(personaConRFC);

            if (persona == null) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado una persona con ese rfc");
                return null;
            }
                PersonaDTO personaDTO = new PersonaDTO(persona.getId(), persona.getRFC(), persona.getNombre(),persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getFechaNacimiento(), persona.getTelefono(),persona.getDiscapacidad(), persona.getCURP());
                return personaDTO;
        } catch (Exception e) {
            System.out.println("Fallo al buscar licencia"+e.getMessage());
            
            return null;
        }
    }
    
    /**
     * 
     * @param persona
     * @param costo
     * @param vigencia 
     */
    @Override
    public void darAltaLicencia(PersonaDTO persona, Float costo, Calendar vigencia) {
        try {
            Persona personal=new Persona(persona.getId(), persona.getRfc(), persona.getCurp(), persona.getFechaNacimiento(), persona.getTelefono(), persona.getNombres(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.isDiscapacidad());
            Licencia licencia=new Licencia(Calendar.getInstance(),costo,vigencia,personal);
            tramiteD.agregarTramite(licencia);
            JOptionPane.showMessageDialog(null, "Se ha dado de alta");
        } catch (Exception e) {
            System.out.println("Fallo al agregar licencia"+e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido dar de alta la licencia");
        }
    }
    
    /**
     * 
     * @param rfc
     * @return 
     */
    @Override
    public boolean verificarLicencia(String rfc) {
        try {
            Persona persona = new Persona();
            persona.setRFC(rfc);

            return tramiteD.verificarLicencia(persona);
        } catch (Exception e) {
            System.out.println("Fallo al buscar licencia"+e.getMessage());
            return false;
        }
    }
    
    /**
     * 
     * @param vehiculo 
     */
    @Override
    public VehiculoDTO agregarVehiculo(VehiculoDTO vehiculo) {
        
        VehiculoDTO guardado=new VehiculoDTO();
        Vehiculo vehicul=new Vehiculo();
        PersonaDTO per=new PersonaDTO();
        Persona persona=new Persona(vehiculo.getPersona().getId(),vehiculo.getPersona().getRfc(), vehiculo.getPersona().getCurp(), vehiculo.getPersona().getFechaNacimiento(), vehiculo.getPersona().getTelefono(), vehiculo.getPersona().getNombres(), vehiculo.getPersona().getApellidoPaterno(), vehiculo.getPersona().getApellidoMaterno(), vehiculo.getPersona().isDiscapacidad());       
        Vehiculo vehiculol=new Automovil(vehiculo.getSerieVehiculo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getLinea(), vehiculo.getColor(), persona);
        vehicul=vehiculoD.agregarVehiculo(vehiculol);
        per.setId(vehicul.getPersona().getId());
        guardado.setId(vehicul.getId());
        guardado.setLinea(vehicul.getLinea());
        guardado.setMarca(vehicul.getMarca());
        guardado.setColor(vehicul.getColor());
        guardado.setModelo(vehicul.getModelo());
        guardado.setPersona(per);
        guardado.setSerieVehiculo(vehicul.getSerieVehiculo());
        JOptionPane.showMessageDialog(null, "Se ha agregado el vehiculo");
        return guardado;
    }

    /**
     * 
     * @param persona
     * @return 
     */
    @Override
    public List<VehiculoDTO> obtenerVehiculos(PersonaDTO persona) {
        List<VehiculoDTO> vehiculosDTO = new ArrayList<>();
        try {
            Persona personal=new Persona(persona.getId(), persona.getRfc(), persona.getCurp(), persona.getFechaNacimiento(), persona.getTelefono(), persona.getNombres(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.isDiscapacidad());       
            List<Vehiculo> vehiculos = vehiculoD.consultarTodoVehiculo(personal);
            for (Vehiculo vehiculo : vehiculos) {
                VehiculoDTO vehiculoDTO = new VehiculoDTO();
                vehiculoDTO.setId(vehiculo.getId());
                vehiculoDTO.setColor(vehiculo.getColor());
                vehiculoDTO.setLinea(vehiculo.getLinea());
                vehiculoDTO.setMarca(vehiculo.getMarca());
                vehiculoDTO.setModelo(vehiculo.getModelo());
                vehiculoDTO.setSerieVehiculo(vehiculo.getSerieVehiculo());
                vehiculoDTO.setPersona(persona);

                vehiculosDTO.add(vehiculoDTO);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vehiculosDTO;
    }

    
    @Override
    public void darAltaPlaca(PersonaDTO persona, Float costo, Calendar recepcion, VehiculoDTO vehiculo) {
        try {
            Persona personal=new Persona(persona.getId(), persona.getRfc(), persona.getCurp(), persona.getFechaNacimiento(), persona.getTelefono(), persona.getNombres(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.isDiscapacidad());       
            Vehiculo vehiculol=new Vehiculo(vehiculo.getId(), vehiculo.getSerieVehiculo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getLinea(), vehiculo.getColor(), personal);
            String serie=tramiteD.generarSerie();
            Placa placa=new Placa(recepcion, serie, EstadoPlaca.ACTIVO, vehiculol, recepcion, costo, personal);
            tramiteD.agregarTramite(placa);
            JOptionPane.showMessageDialog(null, "Se ha dado de alta con la serie "+serie);
        } catch (Exception e) {
            System.out.println("Fallo al dar de alta placa"+e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido dar de alta");
        }
    }

    @Override
    public String[] obtenerPersonas(int tipo) {
        try {
            
            List<Persona> personas = personaD.consultaPersonas();
            List<PersonaDTO> personasDTO = new ArrayList<>();

            for (Persona persona : personas) {
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setId(persona.getId());
                personaDTO.setRfc(persona.getRFC());
                personaDTO.setCurp(persona.getCURP());
                personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
                personaDTO.setTelefono(persona.getTelefono());
                personaDTO.setNombres(persona.getNombre());
                personaDTO.setApellidoPaterno(persona.getApellidoPaterno());
                personaDTO.setApellidoMaterno(persona.getApellidoMaterno());
                personaDTO.setDiscapacidad(persona.getDiscapacidad());

                personasDTO.add(personaDTO);
            }
            String[] lista = new String[personas.size()];
            
            
            if (tipo==1) {
                for (int i = 0; i < personasDTO.size(); i++) {
                    PersonaDTO persona= personasDTO.get(i);
                    lista[i]=persona.getCurp();
                }
            }else if (tipo==2) {
                for (int i = 0; i < personasDTO.size(); i++) {
                    PersonaDTO persona = personasDTO.get(i);
                    String nombreCompleto = persona.getNombres() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
                    lista[i]=nombreCompleto;
                }
            }else if (tipo==3) {
                for (int i = 0; i < personasDTO.size(); i++) {
                    PersonaDTO persona = personasDTO.get(i);
                    Calendar fechaNacimiento = persona.getFechaNacimiento();
                    int año = fechaNacimiento.get(Calendar.YEAR);
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
    public List<TramiteDTO> consultarTramites(String opcion, int tipo, PersonaDTO persona) {
        try {
            List<TramiteDTO> tramites=new ArrayList<>();
            if (tipo==1) {
                Persona pers=new Persona();
                pers.setCURP(opcion);
                List<Tramite> tramite = tramiteD.buscarPorCurp(pers);
                for (Tramite tramiteses:tramite) {
                    TramiteDTO tramitedto=new TramiteDTO();
                    tramitedto.setId(tramiteses.getId());
                    tramitedto.setTipo(tramiteses.getTipo());
                    tramitedto.setCosto(tramiteses.getCosto());
                    tramitedto.setFechaEmision(tramiteses.getFechaEmision());
                    tramites.add(tramitedto);
                }
            }else if (tipo==2) {
                Persona pers=new Persona(persona.getId(),persona.getRfc(),persona.getCurp(),persona.getFechaNacimiento(),persona.getTelefono(),persona.getNombres(),persona.getApellidoPaterno(),persona.getApellidoMaterno(),persona.isDiscapacidad());
                List<Tramite> tramite = tramiteD.buscarPorCurp(pers);
                for (Tramite tramiteses:tramite) {
                    TramiteDTO tramitedto=new TramiteDTO();
                    tramitedto.setId(tramiteses.getId());
                    tramitedto.setTipo(tramiteses.getTipo());
                    tramitedto.setCosto(tramiteses.getCosto());
                    tramitedto.setFechaEmision(tramiteses.getFechaEmision());
                    tramitedto.setPersona(persona);
                    tramites.add(tramitedto);
                }
            }
            return tramites;
        } catch (Exception e) {
            System.out.println("Error al consultar los tramites"+e.getMessage());
        }
        return null;
    }

    @Override
    public List<PersonaDTO> consultaEspecificaPersonas(String opcion, int tipo) {
        
        try {
            List<PersonaDTO> personas=new ArrayList<>();
            if (tipo==2) {
                List<Persona> pers=personaD.consultaPersonaNombre(opcion);
                for (Persona persos: pers) {
                    PersonaDTO per=new PersonaDTO();
                    per.setId(persos.getId());
                    per.setNombres(persos.getNombre());
                    per.setApellidoPaterno(persos.getApellidoPaterno());
                    per.setApellidoMaterno(persos.getApellidoMaterno());
                    per.setCurp(persos.getCURP());
                    per.setRfc(persos.getRFC());
                    per.setFechaNacimiento(persos.getFechaNacimiento());
                    per.setTelefono(persos.getTelefono());
                    personas.add(per);
                }   
            }else if (tipo==3) {
                int año= Integer.parseInt(opcion);
                Persona pr=new Persona();
                Calendar fecha=Calendar.getInstance();
                fecha.set(Calendar.YEAR, año);
                pr.setFechaNacimiento(fecha);
                List<Persona> pers=personaD.consultaPersonaAño(pr);
                for (Persona persos: pers) {
                    PersonaDTO per=new PersonaDTO();
                    per.setId(persos.getId());
                    per.setNombres(persos.getNombre());
                    per.setApellidoPaterno(persos.getApellidoPaterno());
                    per.setApellidoMaterno(persos.getApellidoMaterno());
                    per.setCurp(persos.getCURP());
                    per.setRfc(persos.getRFC());
                    per.setFechaNacimiento(persos.getFechaNacimiento());
                    per.setTelefono(persos.getTelefono());
                    personas.add(per);
                }   
            }
            return personas;
        } catch (Exception e) {
            System.out.println("Fallo en consultar personas"+e.getMessage());
        }
        return null;
    }

    @Override
    public List<TramiteDTO> consultaEspecificaTipoPeriodo(String tipoT, int tipo, Calendar fechaI, Calendar fechaF) {
        
        try {
            List<TramiteDTO> tramites=new ArrayList<>();
            if (tipo==1) {
                List<Tramite> tramite=tramiteD.buscarPorTipo(tipoT);
                for (Tramite tramiteses:tramite) {
                    TramiteDTO tramitedto=new TramiteDTO();
                    tramitedto.setId(tramiteses.getId());
                    tramitedto.setTipo(tramiteses.getTipo());
                    tramitedto.setCosto(tramiteses.getCosto());
                    tramitedto.setFechaEmision(tramiteses.getFechaEmision());
                    
                    PersonaDTO per=new PersonaDTO();
                    per.setNombres(tramiteses.getPersonas().getNombre());
                    per.setApellidoPaterno(tramiteses.getPersonas().getApellidoPaterno());
                    per.setApellidoMaterno(tramiteses.getPersonas().getApellidoMaterno());
                    
                    tramitedto.setPersona(per);
                    tramites.add(tramitedto);
                }
            }else if (tipo==2) {
                List<Tramite> tramite=tramiteD.buscarPorPeriodo(fechaI, fechaF);
                for (Tramite tramiteses:tramite) {
                    TramiteDTO tramitedto=new TramiteDTO();
                    tramitedto.setId(tramiteses.getId());
                    tramitedto.setTipo(tramiteses.getTipo());
                    tramitedto.setCosto(tramiteses.getCosto());
                    tramitedto.setFechaEmision(tramiteses.getFechaEmision());
                    
                    PersonaDTO per=new PersonaDTO();
                    per.setNombres(tramiteses.getPersonas().getNombre());
                    per.setApellidoPaterno(tramiteses.getPersonas().getApellidoPaterno());
                    per.setApellidoMaterno(tramiteses.getPersonas().getApellidoMaterno());
                    per.setId(tramiteses.getPersonas().getId());
                    per.setCurp(tramiteses.getPersonas().getCURP());
                    per.setRfc(tramiteses.getPersonas().getRFC());
                    
                    tramitedto.setPersona(per);
                    tramites.add(tramitedto);
                }
            }
            
            return tramites;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    
}
