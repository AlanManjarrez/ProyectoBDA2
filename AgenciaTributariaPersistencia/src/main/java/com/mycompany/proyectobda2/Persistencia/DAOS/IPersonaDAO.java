/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;

import java.util.List;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
/**
 *
 * @author uirtis
 */
public interface IPersonaDAO {
    
    public PersonaDTO consultarPersonaRFC(String RFC);
    
    public void insercionPersonas();
    
}
