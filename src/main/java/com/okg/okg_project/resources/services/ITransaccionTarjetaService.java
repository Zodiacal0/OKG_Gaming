/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.TransaccionTarjeta;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface ITransaccionTarjetaService {
    public void crearTransaccionTarjeta(TransaccionTarjeta transaccionTarjeta);
    
    public List<TransaccionTarjeta> listarTransaccionTarjeta();
    
    public TransaccionTarjeta buscarTransaccionTarjeta(int idTransaccionTarjeta);
    
    public void editarTransaccionTarjeta(TransaccionTarjeta transaccionTarjeta);
    
    public void eliminarTransaccionTarjeta(int idTransaccionTarjeta);
}
