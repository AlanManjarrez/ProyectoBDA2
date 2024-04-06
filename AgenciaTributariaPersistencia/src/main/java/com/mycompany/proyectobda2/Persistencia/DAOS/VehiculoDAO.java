/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import com.mycompany.agenciatributarianegocio.DTO.AutomovilDTO;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JESUS
 */
public class VehiculoDAO implements IVehiculo{

    @Override
    public void agregarVehiculo(VehiculoDTO vehiculo) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            entityManager.getTransaction().begin();
            Vehiculo vehiculoEntity=null;
            if (vehiculo instanceof AutomovilDTO) {
                Persona per=entityManager.find(Persona.class, vehiculo.getPersona().getId());
                Automovil auto=new Automovil(vehiculo.getSerieVehiculo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getLinea(), vehiculo.getColor(), per);
                vehiculoEntity=auto;
            }
            entityManager.persist(vehiculoEntity);
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
