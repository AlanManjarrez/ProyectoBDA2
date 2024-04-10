/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Vehiculo;
import java.util.List;
/**
 *
 * @author JESUS
 */

public interface Ivehiculo {
    
    /**
     * Metodo que agrega un vehiculo
     * @param vehiculo vehiculo a agregar
     */
    public void agregarVehiculo(Vehiculo vehiculo);
    
    /**
     * Metodo que regresa todos los vehiculos de una persona
     * @param persona persona a buscar  
     * @return lista de vehiculos
     */
    public List<Vehiculo> consultarTodoVehiculo(Persona  persona);
}
