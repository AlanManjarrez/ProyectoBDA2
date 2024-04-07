/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import com.mycompany.agenciatributarianegocio.DTO.AutomovilDTO;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import java.util.List;
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
                
                if (per != null) {
                AutomovilDTO automovilDTO = (AutomovilDTO) vehiculo;
                Automovil automovil = new Automovil(automovilDTO.getSerieVehiculo(), automovilDTO.getMarca(),automovilDTO.getModelo(), automovilDTO.getLinea(), automovilDTO.getColor(), per);
                vehiculoEntity = automovil;
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
    }

    @Override
    public List<VehiculoDTO> consultarTodoVehiculo(PersonaDTO persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
            
}
