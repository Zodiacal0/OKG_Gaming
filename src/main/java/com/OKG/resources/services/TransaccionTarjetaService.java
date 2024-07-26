/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.TransaccionTarjeta;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class TransaccionTarjetaService implements ITransaccionTarjetaService {
    private EntityManager em;
     public TransaccionTarjetaService() {
        this.em = JpaUtil.getEntityManager();
    }
    @Override
    public void crearTransaccionTarjeta(TransaccionTarjeta transaccionTarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TransaccionTarjeta> listarTransaccionTarjeta() {
        TypedQuery<TransaccionTarjeta> query = em.createQuery("SELECT FORM u TRANSACCIONTARJETA u",TransaccionTarjeta.class);
        return query.getResultList();
    }

    @Override
    public TransaccionTarjeta buscarTransaccionTarjeta(int idTransaccionTarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarTransaccionTarjeta(TransaccionTarjeta transaccionTarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTransaccionTarjeta(int idTransaccionTarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
