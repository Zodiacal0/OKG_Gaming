/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Paypal;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IPaypalService {
    public void crearPaypal(Paypal paypal);
    
    public List<Paypal> listarPaypal();
    
    public Paypal buscarPaypal(int idPaypal);
    
    public void editarPaypal(Paypal paypal);
    
    public void eliminarPaypal(int idPaypal);
}
