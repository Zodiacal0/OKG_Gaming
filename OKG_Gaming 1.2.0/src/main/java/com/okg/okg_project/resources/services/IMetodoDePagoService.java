/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.MetodoDePago;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IMetodoDePagoService {
    public void crearMetodoDePago(MetodoDePago metodoDePago);
    
    public List<MetodoDePago>listarMetodoDePago();
    
    public MetodoDePago buscarMetodoDePago(int idMetodoDePago);
    
    public void  editarMetodoDePago(MetodoDePago metodoDePago);
    
    public void eliminarMetodoDePago(int idMetodoDePago);
}
