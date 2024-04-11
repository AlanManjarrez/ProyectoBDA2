/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JESUS
 */
public class VehiculoDAO implements Ivehiculo{
    
    /**
     * Metodo que agrega el vehiculo y lo regresa 
     * @param vehiculo
     * @return 
     */
    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Vehiculo vehiculoEntity=null;
        try {
            entityManager.getTransaction().begin();
            
            if (vehiculo instanceof Automovil) {
                Persona per=entityManager.find(Persona.class, vehiculo.getPersona().getId());
                
                if (per != null) {
                    Automovil automovil = (Automovil) vehiculo;
                    Automovil automoviles = new Automovil(automovil.getSerieVehiculo(), automovil.getMarca(),automovil.getModelo(), automovil.getLinea(), automovil.getColor(), per);
                    vehiculoEntity = automoviles;
                } else {
                    System.out.println("La persona asociada al vehículo no existe en la base de datos.");
                }
            }
            if (vehiculoEntity != null) {
                entityManager.persist(vehiculoEntity);
                entityManager.getTransaction().commit();
                
            } else {
                System.out.println("No se pudo persistir el vehículo debido a problemas de datos.");
            }
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        entityManager.close();
        entityManagerFactory.close();
       return vehiculoEntity;
    }
    
    /**
     * Metodo que regresa todos los vehiculos de una persona
     * @param persona persona a buscar  
     * @return lista de vehiculos
     */
    @Override
    public List<Vehiculo> consultarTodoVehiculo(Persona persona) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Vehiculo> vehiculos =new ArrayList<>();
        try {
            entityManager.getTransaction().begin();

            // Consulta JPQL para obtener los vehículos de una persona específica
            vehiculos = entityManager.createQuery("SELECT v FROM vehiculos v WHERE v.persona.id = :personaId", Vehiculo.class)
                .setParameter("personaId", persona.getId())
                .getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return vehiculos;
    }
    
    
}
