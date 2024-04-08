/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;
import com.mycompany.agenciatributarianegocio.DTO.TramiteDTO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author uirtis
 */
public interface ITramiteDAO {

    public void agregarTramite(TramiteDTO tramite);
    
    public boolean verificarLicencia(String RFC);
    
    public String generarSerie();
    
    public String generaSerieAleatori();
    
    public boolean verificarExistenciaSerie(String serie,EntityManager entity);
    
    public List<TramiteDTO> buscarPorCurp(String curp);
    
    public List<TramiteDTO> buscarPorAño(String año);
}
