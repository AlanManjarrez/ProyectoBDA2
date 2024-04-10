/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import java.util.List;

/**
 *
 * @author uirtis
 */
public interface IPersonaDAO {
    
    /**
     * Metodo que busca a una persona por su RFC
     * @param rfc rfc de la persona 
     * @return la persona del rfc buscado
     */
    public Persona consultarPersonaRFC(Persona rfc);
    
    /**
     * Agrega 20 personas a la base de datos
     */
    public void insercionPersonas();
    
    /**
     * Metodo que devuelve a todas las personas de la base de datos
     * @return lista de personas
     */
    public List<Persona> consultaPersonas();
    
    /**
     * Metodo que busca a todas las personas por un año en especifico de su fecha de nacimiento
     * @param año año que se va a buscar
     * @return lista de personas que tengan ese año en su fecha de nacimiento
     */
    public List<Persona> consultaPersonaAño(Persona año);
    
    /**
     * Metodo que devuelve a las personas que tenga el nombre que recibe
     * @param nombreCompleto nombre a buscar
     * @return lista de personas con ese nombre
     */
    public List<Persona> consultaPersonaNombre(String nombreCompleto);
    
}
