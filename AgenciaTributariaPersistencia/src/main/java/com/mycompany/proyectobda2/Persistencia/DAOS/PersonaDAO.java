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

            persona1=new PersonaDTO(persona.getId(),persona.getRFC(),persona.getNombre(),persona.getApellidoPaterno(),persona.getApellidoMaterno(),persona.getFechaNacimiento(),persona.getTelefono(),persona.getDiscapacidad());     
        
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
}
