/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyectobda2;

import com.mycompany.agenciatributarianegocio.DTO.AutomovilDTO;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Automovil;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.EstadoPlaca;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Placa;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Tramite;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import com.mycompany.proyectobda2.Persistencia.DAOS.PersonaDAO;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.PlacaDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import com.mycompany.proyectobda2.Persistencia.DAOS.TramiteDAO;
import com.mycompany.proyectobda2.Persistencia.DAOS.VehiculoDAO;
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
        TramiteDAO t=new TramiteDAO();
        System.out.println(t.verificarLicencia("ABCD123456XYZ"));
        
        /*
        VehiculoDAO v=new VehiculoDAO();
        Calendar fechaNacimiento = Calendar.getInstance();
        
        PersonaDTO per=new PersonaDTO(1L,"ABCD123456XYZ", "Juan", "Pérez", "González", fechaNacimiento, "1234567890", true, "ABCX123456XYZ789");
        List<VehiculoDTO> vehiculos = v.consultarTodoVehiculo(per);

        
        for (VehiculoDTO vehiculo : vehiculos) {
            System.out.println("ID: " + vehiculo.getId());
            System.out.println("Serie de Vehículo: " + vehiculo.getSerieVehiculo());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Línea: " + vehiculo.getLinea());
            System.out.println("Color: " + vehiculo.getColor());
            

            System.out.println(); 
        }
        
        
        List<Vehiculo> veh = v.obtenerTodosLosVehiculos();
        for (Vehiculo vehiculo : veh) {
            System.out.println(vehiculo.toString());
        }
        
        */
        
        /*
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaRecepcion = Calendar.getInstance();
        Calendar fechaEmision = Calendar.getInstance();
        Calendar vigencia = Calendar.getInstance();
        fechaNacimiento.set(2001, Calendar.MONTH, 10);
        fechaRecepcion.set(2024, Calendar.MONTH, 24);
        fechaEmision.set(2022, Calendar.MONTH, 30);
        vigencia.set(2024, Calendar.MONTH, 2);
        
        

        Persona persona = new Persona("ABCD123456XYZ", "ABCX123456XYZ789", fechaNacimiento, "1234567890", "Juan", "Pérez", "González", false);
        Automovil automovil = new Automovil("V123456789", "Toyota", "Corolla", "Sedán", "Blanco", persona);
        
        
        Placa placa = new Placa(fechaRecepcion, "ABC123",EstadoPlaca.ACTIVO, automovil, fechaEmision, 300.00f, persona);
        

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("conexionPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(persona);
        entityManager.persist(automovil);
        entityManager.persist(placa);
        

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
*/
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
