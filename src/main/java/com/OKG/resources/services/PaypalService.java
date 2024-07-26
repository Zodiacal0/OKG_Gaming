/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Paypal;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class PaypalService implements IPaypalService {

    private EntityManager em;

     public PaypalService() {
        this.em = JpaUtil.getEntityManager();
    }
    @Override
    public void crearPaypal(Paypal paypal) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(paypal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Paypal> listarPaypal() {
        TypedQuery<Paypal> query = em.createQuery("SELECT FROM u PAYPAL u", Paypal.class);
        return query.getResultList();
    }
    
    @Override
    public Paypal buscarPaypal(int idPaypal) {
        return em.find(Paypal.class, idPaypal);
    }
    
    @Override
    public void editarPaypal(Paypal paypal) {
        em.merge(paypal);
    }
    
    @Override
    public void eliminarPaypal(int idPaypal) {
        Paypal paypal = buscarPaypal(idPaypal);
        if (paypal != null) {
            em.remove(paypal);
        }
    }
    
}
