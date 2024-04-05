/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyectobda2;

import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.EstadoPlaca;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.EstadoVehiculo;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Placa;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Tramite;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author uirtis
 */
public class ProyectoBDA2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
        
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaRecepcion = Calendar.getInstance();
        Calendar fechaEmision = Calendar.getInstance();
        Calendar vigencia = Calendar.getInstance();
        fechaNacimiento.set(2001, Calendar.MONTH, 10);
        fechaRecepcion.set(2024, Calendar.MONTH, 24);
        fechaEmision.set(2022, Calendar.MONTH, 30);
        vigencia.set(2024, Calendar.MONTH, 2);
        
        

        Persona persona = new Persona("ABCD123456XYZ", "ABCX123456XYZ789", fechaNacimiento, "1234567890", "Juan", "Pérez", "González", false);
        Automovil automovil = new Automovil("V123456789", "Toyota", "Corolla", "Sedán", "Blanco", EstadoVehiculo.NUEVO, persona);
        
        
        Placa placa = new Placa(fechaRecepcion, "ABC123",EstadoPlaca.ACTIVO, automovil, fechaEmision, 300.00f, vigencia, persona);
        

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(persona);
        entityManager.persist(automovil);
        entityManager.persist(placa);
        

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

/*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionPU"); // Reemplaza "tu_unidad_de_persistencia" por el nombre de tu unidad de persistencia
        EntityManager em = emf.createEntityManager();

        // Comienza la transacción
        em.getTransaction().begin();

        // Consulta JPQL para obtener todas las personas
        String jpql = "SELECT p FROM personas p";
        Query query = em.createQuery(jpql);

        // Ejecutar la consulta y obtener el resultado como una lista de objetos Persona
        List<Persona> personas = query.getResultList();

        // Imprimir los resultados
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        // Termina la transacción
        em.getTransaction().commit();

        // Cierra el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
*/
    }
}
