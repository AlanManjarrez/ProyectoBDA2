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
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Licencia;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Placa;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Tramite;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import java.util.Calendar;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
                Persona persona = entityManager.find(Persona.class, licen.getPersona().getId());
                Licencia licencia=new Licencia(licen.getFechaEmision(), licen.getCosto(), licen.getVigencia(), persona);
                tramityEntity=licencia;
            }else if (tramite instanceof PlacaDTO) {
                PlacaDTO pla=(PlacaDTO)tramite;
                Persona persona = entityManager.find(Persona.class, pla.getPersona().getId());
                Vehiculo vehiculo= entityManager.find(Vehiculo.class, pla.getVehiculo().getId());
                
                // Buscar la placa asociada al vehículo
                Placa placa = null;
                Query query = entityManager.createQuery("SELECT p FROM Placa p WHERE p.vehiculo = :vehiculo");
                query.setParameter("vehiculo", vehiculo);
                List<Placa> placas = query.getResultList();
                if (!placas.isEmpty()) {
                    placa = placas.get(0);
                }

                // Verificar si se encontró una placa asociada al vehículo
                if (placa == null) {
                    // Si no se encontró, crear una nueva placa
                    placa = new Placa(pla.getFechaEmision(), pla.getSeriePlacas(), EstadoPlaca.valueOf(pla.getEstadoPlacas()), vehiculo, pla.getFechaEmision(), pla.getCosto(), pla.getVigencia(), persona);
                    tramityEntity = placa;
                } else {
                    // Si se encontró una placa, verificar si su estado es activo
                    if (placa.getEstadoPlaca() == EstadoPlaca.ACTIVO) {
                        // Cambiar el estado de la placa a no activo
                        placa.setEstadoPlaca(EstadoPlaca.NO_ACTIVO);
                        entityManager.merge(placa);

                        // Crear una nueva placa
                        Placa nuevaPlaca = new Placa(pla.getFechaEmision(), pla.getSeriePlacas(), EstadoPlaca.ACTIVO, vehiculo, pla.getFechaEmision(), pla.getCosto(), pla.getVigencia(), persona);
                        tramityEntity = nuevaPlaca;
                    } else {
                        // Manejar el caso en que el vehículo ya tiene una placa asociada pero no está activa
                        System.out.println("El vehículo ya tiene una placa asociada pero no está activa.");
                    }
                }
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

    @Override
    public boolean verificarLicencia(String RFC) {
        Calendar hoy= Calendar.getInstance();
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            entityManager.getTransaction().begin();
            
            Long cantidadLicenciasVigentes = entityManager.createQuery("SELECT COUNT(t) FROM tramites t WHERE t.personas.RFC = :RFC AND t.vigencia >= :fechaActual", Long.class)
                    .setParameter("RFC", RFC)
                    .setParameter("fechaActual", hoy)
                    .getSingleResult();
            
            
            entityManager.getTransaction().commit();

            // Si la cantidad de licencias vigentes es mayor a cero, significa que la persona tiene una licencia vigente
            return cantidadLicenciasVigentes > 0;
        } catch (NoResultException e) {
            // Aquí manejamos la excepción y devolvemos false, ya que no se encontró ninguna licencia vigente
            System.out.println("No se encontró ninguna licencia vigente para la persona con el ID proporcionado.");
            return false;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        
    }
}
