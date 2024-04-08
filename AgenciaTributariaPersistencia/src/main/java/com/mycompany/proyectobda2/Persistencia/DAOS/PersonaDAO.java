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
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author uirtis
 */
public class PersonaDAO implements IPersonaDAO {


    @Override
    public PersonaDTO consultarPersonaRFC(String RFC) {
        PersonaDTO persona1=null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Persona persona = entityManager.createQuery("SELECT P FROM personas P WHERE P.RFC = :RFC", Persona.class).setParameter("RFC", RFC).getSingleResult();

            persona1=new PersonaDTO(persona.getId(),persona.getRFC(),persona.getNombre(),persona.getApellidoPaterno(),persona.getApellidoMaterno(),persona.getFechaNacimiento(),persona.getTelefono(),persona.getDiscapacidad(),persona.getCURP());     
        
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

    
    @Override
    public List<PersonaDTO> consultaPersonas() {
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
            
            // Convertir la lista de Personas a una lista de PersonaDTOs
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
            return personasDTO;

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null; // O manejar el error de otra manera
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<PersonaDTO> consultaPersonaAño(String año) {
        List<PersonaDTO> personasAño = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            int year = Integer.parseInt(año);

            // Crear una instancia de Calendar para el año proporcionado
            Calendar calendarInicio = Calendar.getInstance();
            calendarInicio.set(Calendar.YEAR, year);
            calendarInicio.set(Calendar.MONTH, Calendar.JANUARY);
            calendarInicio.set(Calendar.DAY_OF_MONTH, 1);

            Calendar calendarFin = Calendar.getInstance();
            calendarFin.set(Calendar.YEAR, year);
            calendarFin.set(Calendar.MONTH, Calendar.DECEMBER);
            calendarFin.set(Calendar.DAY_OF_MONTH, 31);

            // Iniciar una transacción
            entityManager.getTransaction().begin();

            // Consultar personas por año de nacimiento
            Query query = entityManager.createQuery("SELECT p FROM personas p WHERE p.fechaNacimiento BETWEEN :fechaInicio AND :fechaFin");
            query.setParameter("fechaInicio", calendarInicio);
            query.setParameter("fechaFin", calendarFin);

            // Obtener el resultado de la consulta
            List<Persona> personas = query.getResultList();

            // Completar la transacción
            entityManager.getTransaction().commit();

            // Convertir la lista de Personas a una lista de PersonaDTOs
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
                personasAño.add(personaDTO);
            }

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
        return personasAño;
    }

    @Override
    public List<PersonaDTO> consultaPersonaNombre(String nombreCompleto) {
        List<PersonaDTO> personasNombre = new ArrayList<>();
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
            List<Persona> personas = query.getResultList();

            // Completar la transacción
            entityManager.getTransaction().commit();

            // Convertir la lista de Personas a una lista de PersonaDTOs
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
                personasNombre.add(personaDTO);
            }

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
