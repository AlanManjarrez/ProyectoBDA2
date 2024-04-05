/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import com.mycompany.agenciatributarianegocio.DTO.LicenciaDTO;
import com.mycompany.agenciatributarianegocio.DTO.PlacaDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.EstadoPlaca;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.EstadoVehiculo;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Licencia;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Placa;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Tramite;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;

/**
 *
 * @author uirtis
 */
public class TramiteDAO implements ITramiteDAO {

    @Override
    public void agregarTramite(TramiteDTO tramite) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            
            Tramite tramityEntity= null; 
            
            if (tramite instanceof LicenciaDTO) {
                LicenciaDTO licen=(LicenciaDTO)tramite;
                Persona persona=new Persona(licen.getPersona().getId(),licen.getPersona().getRfc(),licen.getPersona().getCurp() ,licen.getPersona().getFechaNacimiento(), licen.getPersona().getTelefono(), licen.getPersona().getNombres(), licen.getPersona().getApellidoPaterno(), licen.getPersona().getApellidoMaterno(), licen.getPersona().isDiscapacidad());
                Licencia licencia=new Licencia(licen.getFechaEmision(), licen.getCosto(), licen.getVigencia(), persona);
                tramityEntity=licencia;
            }else if (tramite instanceof PlacaDTO) {
                PlacaDTO pla=(PlacaDTO)tramite;
                Persona persona=new Persona(pla.getPersona().getId(),pla.getPersona().getRfc(),pla.getPersona().getCurp() ,pla.getPersona().getFechaNacimiento(), pla.getPersona().getTelefono(), pla.getPersona().getNombres(), pla.getPersona().getApellidoPaterno(), pla.getPersona().getApellidoMaterno(), pla.getPersona().isDiscapacidad());
                Vehiculo vehiculo= new Automovil(pla.getVehiculo().getSerieVehiculo(), pla.getVehiculo().getMarca(), pla.getVehiculo().getModelo(), pla.getVehiculo().getLinea(), pla.getVehiculo().getColor(), EstadoVehiculo.valueOf(pla.getVehiculo().getEstadoVehiculo()), persona);
                Placa placa=new Placa(pla.getFechaRecepcion(), pla.getSeriePlacas(), EstadoPlaca.valueOf(pla.getEstadoPlacas()), vehiculo, pla.getFechaEmision(), pla.getCosto(), pla.getVigencia(), persona);
                tramityEntity=placa;
            }
            entityManager.persist(tramityEntity);      
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
