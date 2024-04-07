/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectobda2.Persistencia.DAOS;
import com.mycompany.agenciatributarianegocio.DTO.PersonaDTO;
import com.mycompany.agenciatributarianegocio.DTO.VehiculoDTO;
import java.util.List;
/**
 *
 * @author JESUS
 */
public interface IVehiculo {
    
    public void agregarVehiculo(VehiculoDTO vehiculo);
    
    public List<VehiculoDTO> consultarTodoVehiculo(PersonaDTO persona);
}
