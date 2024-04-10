/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author uirtis
 */
public class TramiteDAO implements ITramiteDAO {
    
    /**
     * Metodo paara agregar un tramite
     * @param tramite tramite que se quiere agregar
     */
    @Override
    public void agregarTramite(Tramite tramite) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            
            Tramite tramityEntity= null; 
            
            if (tramite instanceof Licencia) {
                Licencia licen=(Licencia)tramite;
                Persona persona = entityManager.find(Persona.class, licen.getPersonas().getId());
                Licencia licencia=new Licencia(licen.getFechaEmision(), licen.getCosto(), licen.getVigencia(), persona);
                tramityEntity=licencia;
            }else if (tramite instanceof Placa) {
                Placa pla=(Placa)tramite;
                Persona persona = entityManager.find(Persona.class, pla.getPersonas().getId());
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
                    
                    placa = new Placa(pla.getFechaEmision(), pla.getSeriePlacas(), pla.getEstadoPlaca(), vehiculo, pla.getFechaEmision(), pla.getCosto(), persona);
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

    /**
     * Metodo para verificar si una persona cuenta con una licencia por medio de su rfc
     * @param rfc rfc de la persona que se quiere verificar
     * @return un boleano si tiene true sino false
     */
    @Override
    public boolean verificarLicencia(Persona rfc) {
        Calendar hoy= Calendar.getInstance();
        String RFC=rfc.getRFC().toUpperCase();;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            entityManager.getTransaction().begin();
            
             Long cantidadLicenciasVigentes = entityManager.createQuery("SELECT COUNT(l) FROM licencias l JOIN l.personas p WHERE p.RFC = :RFC AND l.vigencia >= :fechaActual", Long.class)
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
    
    /**
     * Metodo que generea la serie para las placas
     * @return la serie de las placas
     */
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
    
    /**
     * Metodo auxiliar para la generacion de series de placas, genera la placas tomando aleatoriamente tres letras luego un guion y por ultimo tres digitos
     * @return 
     */
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
    
    /**
     * Metodo auxiliar para le generacion de serie de placas, verifica que no exista la serie de placa
     * @param serie la serie que se va a checar
     * @param entity entityManager para realizar la consulta
     * @return un numero si es 0 es que no hay duplicacion de placas, si es mayor es que hay duplicacion
     */
    @Override
    public boolean verificarExistenciaSerie(String serie,EntityManager entity) {
        Query query = entity.createQuery("SELECT COUNT(p) FROM Placa p WHERE p.seriePlacas = :serie");
        query.setParameter("serie", serie);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }
    
    /**
     * Metodo que busca las personas por la curp y regresa todos sus tramites
     * @param CURP curp de la persona
     * @return lista de tramites
     */
    @Override
    public List<Tramite> buscarPorCurp(Persona CURP) {
        String curp=CURP.getCURP().toUpperCase();
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

            // Completar la transacción
            entityManager.getTransaction().commit();

            return tramites;
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
    
    /**
     * Metodo que busca a una persona y regresa todos sus tramites
     * @param persona persona que quiere consultar sus tramites
     * @return lista de tramites
     */
    @Override
    public List<Tramite> buscarPorNombreAño(Persona persona) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Tramite> tramites=new ArrayList<>();
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
                tramites = query.getResultList();

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

        return tramites;
    }

    /**
     * Metodo que busca todos los tramites hechos en un perido de tiempo
     * @param inicio fecha inicial
     * @param fin fecha limite
     * @return lista de tramites que hay en ese periodo
     */
    @Override
    public List<Tramite> buscarPorPeriodo(Calendar inicio, Calendar fin) {
        List<Tramite> tramites = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Iniciar una transacción
            entityManager.getTransaction().begin();
            
            // Consulta para obtener todos los trámites dentro del periodo especificado
            Query query = entityManager.createQuery("SELECT t FROM tramites t WHERE t.fechaEmision BETWEEN :inicio AND :fin");
            query.setParameter("inicio",inicio );
            query.setParameter("fin", fin);
            tramites = query.getResultList();

            // Completar la transacción
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al buscar los trámites por periodo: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return tramites;
    }
    
    /**
     * Metodo que regresa todos los tramites segun su tipo
     * @param TIPO tipo de tramite a buscar
     * @return lista de tramites
     */
    @Override
    public List<Tramite> buscarPorTipo(Tramite TIPO) {
        List<Tramite> tramites = new ArrayList<>();
        String tipo=TIPO.getTipo();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consulta para obtener todos los trámites del tipo especificado
            Query query = entityManager.createQuery("SELECT t FROM tramites t WHERE t.tipo = :tipo");
            query.setParameter("tipo", tipo);
            tramites = query.getResultList();
            
            // Completar la transacción
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al buscar los trámites por tipo: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return tramites;
    }
    
    
}
