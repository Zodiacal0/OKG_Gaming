/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.TransaccionTarjeta;
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
