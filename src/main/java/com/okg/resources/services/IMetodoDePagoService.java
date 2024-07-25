/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.MetodoDePago;
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
