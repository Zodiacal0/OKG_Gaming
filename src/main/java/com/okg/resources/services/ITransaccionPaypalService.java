/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.TransaccionPaypal;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface ITransaccionPaypalService {
    public void crearTransaccionPaypal(TransaccionPaypal transaccionPaypal);
    
    public List<TransaccionPaypal> listarTransaccionPaypal();
    
    public TransaccionPaypal buscarTransaccionPaypal(int idTransaccionPaypal);
    
    public void editarTransaccionPaypal(TransaccionPaypal transaccionPaypal);
    
    public void eliminarTransaccionPaypal(int idTransaccionPaypal);
}
