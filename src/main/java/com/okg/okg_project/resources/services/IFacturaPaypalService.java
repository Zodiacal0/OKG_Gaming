/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.FacturaPaypal;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IFacturaPaypalService {
    public void crearFacturaPaypal(FacturaPaypal facturaPaypal);
    
    public List<FacturaPaypal> listarFacturaPaypal();
    
    public FacturaPaypal buscarFacturaPaypal(int idFacturaPaypal);
    
    public void editarFacturaPaypal(FacturaPaypal facturaPaypal);
    
    public void eliminarFacturaPaypal(int idFacturaPaypal);
}
