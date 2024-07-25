/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Carrito;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface ICarritoService {
    public void crearCarrito(Carrito carrito);
    
    public List<Carrito> listarCarrito();
    
    public Carrito buscarCarrito(int idCarrito);
    
    public void editarCarrito(Carrito carrito);
    
    public void eliminarCarrito(int idCarrito);
}
