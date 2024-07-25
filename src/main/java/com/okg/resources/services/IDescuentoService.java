/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Descuento;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IDescuentoService {
    public void crearDescuento(Descuento descuento);
    
    public List<Descuento> listarDescuento();
    
    public Descuento buscarDescuento(int idDescuento);
    
    public void editarDescuento(Descuento descuento);
    
    public void eliminarDescuento(int idDescuento);
}
