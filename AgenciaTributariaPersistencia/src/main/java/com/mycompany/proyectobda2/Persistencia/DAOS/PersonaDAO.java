/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author uirtis
 */
public class PersonaDAO implements IPersonaDAO {
    
    /**
     * Metodo que busca a una persona por su RFC
     * @param rfc rfc de la persona 
     * @return la persona del rfc buscado
     */
    @Override
    public Persona consultarPersonaRFC(Persona rfc) {
        String RFC=rfc.getRFC();
        Persona persona1=null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Persona persona = entityManager.createQuery("SELECT P FROM personas P WHERE P.RFC = :RFC", Persona.class).setParameter("RFC", RFC).getSingleResult();

            persona1=new Persona(persona.getId(),persona.getRFC(), persona.getCURP(), persona.getFechaNacimiento(), persona.getTelefono(), persona.getNombre(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getDiscapacidad());
            
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            // Aquí manejamos la excepción y devolvemos null
            System.out.println("No se encontró ninguna persona con el RFC proporcionado.");
            return null;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return persona1; 
    }
    
    /**
     * Agrega 20 personas a la base de datos
     */
    @Override
    public void insercionPersonas() {
        List<Persona> personas = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Calendar fechaNacimiento = Calendar.getInstance();

            fechaNacimiento.set(2000 + i, Calendar.MARCH, i);

            Persona persona = new Persona(
                    "RFC" + i,
                    "CURP" + i,
                    fechaNacimiento,
                    "123456789" + i,
                    "Nombre" + i,
                    "ApellidoPaterno" + i,
                    "ApellidoMaterno" + i,
                    i % 2 == 0 
            );
            personas.add(persona);
        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            for (Persona persona : personas) {
                entityManager.persist(persona);
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback(); 
        } finally {
            entityManager.close(); 
            entityManagerFactory.close(); 
        }
    }

    /**
     * Metodo que devuelve a todas las personas de la base de datos
     * @return lista de personas
     */
    @Override
    public List<Persona> consultaPersonas() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consulta para obtener todas las personas
            Query query = entityManager.createQuery("SELECT p FROM personas p");

            // Obtener la lista de personas
            List<Persona> personas = query.getResultList();

            // Completar la transacción
            entityManager.getTransaction().commit();
            
            return personas;

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null; // O manejar el error de otra manera
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    /**
     * Metodo que busca a todas las personas por un año en especifico de su fecha de nacimiento
     * @param año año que se va a buscar
     * @return lista de personas que tengan ese año en su fecha de nacimiento
     */
    @Override
    public List<Persona> consultaPersonaAño(Persona año) {
        
        List<Persona> personas=new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Calendar calendarInicio = año.getFechaNacimiento();
            int year = calendarInicio.get(Calendar.YEAR);
            
            calendarInicio.set(Calendar.YEAR, year);
            calendarInicio.set(Calendar.MONTH, Calendar.JANUARY);
            calendarInicio.set(Calendar.DAY_OF_MONTH, 1);

            Calendar calendarFin = (Calendar) calendarInicio.clone();
            calendarFin.set(Calendar.MONTH, Calendar.DECEMBER);
            calendarFin.set(Calendar.DAY_OF_MONTH, 31);

            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consultar personas por año de nacimiento
            Query query = entityManager.createQuery("SELECT p FROM personas p WHERE p.fechaNacimiento BETWEEN :fechaInicio AND :fechaFin");
            query.setParameter("fechaInicio", calendarInicio);
            query.setParameter("fechaFin", calendarFin);

            // Obtener el resultado de la consulta
            personas = query.getResultList();

            // Completar la transacción
            entityManager.getTransaction().commit();

        } catch (NumberFormatException e) {
            // Manejar el error si el año no es un número válido
            e.printStackTrace();
        } catch (Exception e) {
            // Manejar otros errores
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return personas;
    }

    /**
     * Metodo que devuelve a las personas que tenga el nombre que recibe
     * @param nombreCompleto nombre a buscar
     * @return lista de personas con ese nombre
     */
    @Override
    public List<Persona> consultaPersonaNombre(String nombreCompleto) {
        List<Persona> personasNombre = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Dividir el nombre completo en nombre, apellido paterno y apellido materno
            String[] partesNombre = nombreCompleto.split(" ");
            String nombre = partesNombre[0];
            String apellidoPaterno = partesNombre[1];
            String apellidoMaterno = partesNombre[2];

            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consultar personas por nombre completo
            Query query = entityManager.createQuery("SELECT p FROM personas p WHERE p.nombre = :nombre AND p.apellidoPaterno = :apellidoPaterno AND p.apellidoMaterno = :apellidoMaterno");
            query.setParameter("nombre", nombre);
            query.setParameter("apellidoPaterno", apellidoPaterno);
            query.setParameter("apellidoMaterno", apellidoMaterno);

            // Obtener el resultado de la consulta
            personasNombre = query.getResultList();

            // Completar la transacción
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            // Manejar errores
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return personasNombre;    
    }
    
    
    
}
