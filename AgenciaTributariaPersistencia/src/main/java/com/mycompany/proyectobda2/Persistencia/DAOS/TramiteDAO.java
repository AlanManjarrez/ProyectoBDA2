/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import com.mycompany.agenciatributarianegocio.DTO.LicenciaDTO;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
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
                    placa = new Placa(pla.getFechaEmision(), pla.getSeriePlacas(), EstadoPlaca.valueOf(pla.getEstadoPlacas()), vehiculo, pla.getFechaEmision(), pla.getCosto(), persona);
                    tramityEntity = placa;
                } else {
                    // Si se encontró una placa, verificar si su estado es activo
                    if (placa.getEstadoPlaca() == EstadoPlaca.ACTIVO) {
                        // Cambiar el estado de la placa a no activo
                        placa.setEstadoPlaca(EstadoPlaca.NO_ACTIVO);
                        entityManager.merge(placa);

                        // Crear una nueva placa
                        Placa nuevaPlaca = new Placa(pla.getFechaEmision(), pla.getSeriePlacas(), EstadoPlaca.ACTIVO, vehiculo, pla.getFechaEmision(), pla.getCosto(), persona);
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
            
             Long cantidadLicenciasVigentes = entityManager.createQuery("SELECT COUNT(l) FROM Licencia l JOIN l.personas p WHERE p.RFC = :RFC AND l.vigencia >= :fechaActual", Long.class)
                .setParameter("RFC", RFC)
                .setParameter("fechaActual", hoy)
                .getSingleResult();

            entityManager.getTransaction().commit();

            // Si la cantidad de licencias vigentes es mayor a cero, significa que la persona tiene una licencia vigente
            return cantidadLicenciasVigentes > 0;
        } catch (NoResultException e) {
            // Aquí manejamos la excepción y devolvemos false, ya que no se encontró ninguna licencia vigente
            System.out.println("No se encontró ninguna licencia vigente para la persona con el RFC proporcionado.");
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

    @Override
    public String generarSerie() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            String serie;
            boolean serieExistente;

            do {
                serie = generaSerieAleatori();
                serieExistente = verificarExistenciaSerie(serie, entityManager);
            } while (serieExistente);

            entityManager.getTransaction().commit();

            return serie;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return null; // Manejo de error, puedes devolver un valor predeterminado o lanzar una excepción.
        } finally {
            entityManager.close();
            entityManagerFactory.close();
    }
    }

    @Override
    public String generaSerieAleatori() {
        // Generar tres letras aleatorias
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(letras.charAt(random.nextInt(letras.length())));
        }

        // Generar tres dígitos aleatorios
        int numero = random.nextInt(1000);
        String numeroFormateado = String.format("%03d", numero);

        // Combinar letras y dígitos con un guión en el medio
        return sb.toString() + "-" + numeroFormateado;
    }

    @Override
    public boolean verificarExistenciaSerie(String serie, EntityManager entity) {
        Query query = entity.createQuery("SELECT COUNT(p) FROM Placa p WHERE p.seriePlacas = :serie");
        query.setParameter("serie", serie);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    @Override
    public List<TramiteDTO> buscarPorCurp(String curp) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consulta para obtener la persona con la CURP especificada
            Query query = entityManager.createQuery("SELECT p FROM personas p WHERE p.CURP = :curp");
            query.setParameter("curp", curp);
            Persona persona = (Persona) query.getSingleResult();

            // Consulta para obtener todos los trámites asociados a la persona encontrada
            query = entityManager.createQuery("SELECT t FROM tramites t WHERE t.personas = :persona");
            query.setParameter("persona", persona);
            List<Tramite> tramites = query.getResultList();
            
            
            // Convertir trámites a DTOs
            List<TramiteDTO> tramitesDTO = new ArrayList<>();
            for (Tramite tramite : tramites) {
                TramiteDTO tramiteDTO = new TramiteDTO();
                tramiteDTO.setId(tramite.getId()); // Asigna el ID del trámite al DTO
                tramiteDTO.setFechaEmision(tramite.getFechaEmision());
                tramiteDTO.setCosto(tramite.getCosto());
                tramiteDTO.setTipo(tramite.getTipo());
                tramitesDTO.add(tramiteDTO);
            }

            // Completar la transacción
            entityManager.getTransaction().commit();

            return tramitesDTO;
        } catch (NoResultException e) {
            System.out.println("No se encontró ninguna persona con la CURP especificada.");
        } catch (Exception e) {
            System.out.println("Error al buscar los trámites por CURP: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return null;
    }

    @Override
    public List<TramiteDTO> buscarPorNombreAño(PersonaDTO persona) {
        List<TramiteDTO> tramitesDTO = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consulta para obtener la persona con el ID especificado en el DTO
            Persona personaEncontrada = entityManager.find(Persona.class, persona.getId());

            // Verificar si se encontró la persona
            if (personaEncontrada != null) {
                // Consulta para obtener todos los trámites asociados a la persona encontrada
                Query query = entityManager.createQuery("SELECT t FROM tramites t WHERE t.personas = :persona");
                query.setParameter("persona", personaEncontrada);
                List<Tramite> tramites = query.getResultList();

                // Convertir trámites a DTOs
                for (Tramite tramite : tramites) {
                    TramiteDTO tramiteDTO = new TramiteDTO();
                    tramiteDTO.setId(tramite.getId());
                    tramiteDTO.setFechaEmision(tramite.getFechaEmision());
                    tramiteDTO.setCosto(tramite.getCosto());
                    tramiteDTO.setTipo(tramite.getTipo());
                    tramitesDTO.add(tramiteDTO);
                }
            } else {
                System.out.println("No se encontró ninguna persona con el ID especificado.");
            }

            // Completar la transacción
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al buscar los trámites por ID de persona: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return tramitesDTO;
    }

    
    
    
}
