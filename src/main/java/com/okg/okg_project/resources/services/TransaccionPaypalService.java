/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.TransaccionPaypal;
import com.okg.okg_project.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class TransaccionPaypalService implements ITransaccionPaypalService {

    private EntityManager em;
    
    public TransaccionPaypalService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearTransaccionPaypal(TransaccionPaypal transaccionPaypal) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(transaccionPaypal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<TransaccionPaypal> listarTransaccionPaypal() {
        TypedQuery<TransaccionPaypal> query = em.createQuery("SELECT FROM u TRANSACCIONPAYPAL u", TransaccionPaypal.class);
        return query.getResultList();
    }

    @Override
    public TransaccionPaypal buscarTransaccionPaypal(int idTransaccionPaypal) {
        return em.find(TransaccionPaypal.class, idTransaccionPaypal);
    }

    @Override
    public void editarTransaccionPaypal(TransaccionPaypal transaccionPaypal) {
        em.merge(transaccionPaypal);
    }

    @Override
    public void eliminarTransaccionPaypal(int idTransaccionPaypal) {
        TransaccionPaypal transaccionPaypal = buscarTransaccionPaypal(idTransaccionPaypal);
        if (transaccionPaypal != null) {
            em.remove(transaccionPaypal);
        }
    }

}
