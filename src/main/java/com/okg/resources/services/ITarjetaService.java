/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Tarjeta;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface ITarjetaService {
    
    public void crearTarjeta(Tarjeta tarjeta);
    
    public List<Tarjeta> listarTarjeta();
    
    public Tarjeta buscarTarjeta(int idTarjeta);
    
    public void editarTarjeta(Tarjeta tarjeta);
    
    public void eliminarTarjeta(int idTarjeta);
}
