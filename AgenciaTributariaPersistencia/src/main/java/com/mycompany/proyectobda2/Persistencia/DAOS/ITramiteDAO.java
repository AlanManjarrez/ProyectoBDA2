/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Persona;
import com.mycompany.proyectobda2.Persistencia.EntidadesJPA.Tramite;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author uirtis
 */
public interface ITramiteDAO {

    /**
     * Metodo paara agregar un tramite
     * @param tramite tramite que se quiere agregar
     */
    public void agregarTramite(Tramite tramite);
    
    /**
     * Metodo para verificar si una persona cuenta con una licencia por medio de su rfc
     * @param rfc rfc de la persona que se quiere verificar
     * @return un boleano si tiene true sino false
     */
    public boolean verificarLicencia(Persona rfc);
    
    /**
     * Metodo que generea la serie para las placas
     * @return la serie de las placas
     */
    public String generarSerie();
    
    /**
     * Metodo auxiliar para la generacion de series de placas, genera la placas tomando aleatoriamente tres letras luego un guion y por ultimo tres digitos
     * @return 
     */
    public String generaSerieAleatori();
    
    /**
     * Metodo auxiliar para le generacion de serie de placas, verifica que no exista la serie de placa
     * @param serie la serie que se va a checar
     * @param entity entityManager para realizar la consulta
     * @return un numero si es 0 es que no hay duplicacion de placas, si es mayor es que hay duplicacion
     */
    public boolean verificarExistenciaSerie(String serie,EntityManager entity);
    
    /**
     * Metodo que busca las personas por la curp y regresa todos sus tramites
     * @param CURP curp de la persona
     * @return lista de tramites
     */
    public List<Tramite> buscarPorCurp(Persona CURP);
    
    /**
     * Metodo que busca a una persona y regresa todos sus tramites
     * @param persona persona que quiere consultar sus tramites
     * @return lista de tramites
     */
    public List<Tramite> buscarPorNombreAño(Persona persona);
    
    /**
     * Metodo que busca todos los tramites hechos en un perido de tiempo
     * @param inicio fecha inicial
     * @param fin fecha limite
     * @return lista de tramites que hay en ese periodo
     */
    public List<Tramite> buscarPorPeriodo(Calendar inicio,Calendar fin);
    
    /**
     * Metodo que regresa todos los tramites segun su tipo
     * @param TIPO tipo de tramite a buscar
     * @return lista de tramites
     */
    public List<Tramite> buscarPorTipo(Tramite TIPO);
}
