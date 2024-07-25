/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.FacturaTarjeta;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IFacturaTarjetaService {
    
    public void crearFacturaTarjeta(FacturaTarjeta facturaTarjeta);
    
    public List<FacturaTarjeta> listarFacturaTarjeta();
    
    public FacturaTarjeta buscarFacturaTarjeta(int idFacturaTarjeta);
    
    public void editarFacturaTarjeta(FacturaTarjeta facturaTarjeta);
    
    public void eliminarFacturaTarjeta(int idFacturaTarjeta);
}
