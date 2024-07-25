/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.FacturaPaypal;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author LUIS
 */
public class FacturaPaypalService implements IFacturaPaypalService {

    private EntityManager em;

    public FacturaPaypalService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearFacturaPaypal(FacturaPaypal facturaPaypal) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(facturaPaypal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<FacturaPaypal> listarFacturaPaypal() {
        TypedQuery<FacturaPaypal> query = em.createQuery("SELECT FROM u FACTURAPAYPAL u", FacturaPaypal.class);
        return query.getResultList();
    }

    @Override
    public FacturaPaypal buscarFacturaPaypal(int idFacturaPaypal) {
        return em.find(FacturaPaypal.class, idFacturaPaypal);
    }

    @Override
    public void editarFacturaPaypal(FacturaPaypal facturaPaypal) {
        em.merge(facturaPaypal);
    }

    @Override
    public void eliminarFacturaPaypal(int idFacturaPaypal) {
        FacturaPaypal facturaPaypal = buscarFacturaPaypal(idFacturaPaypal);
        if (facturaPaypal != null) {
            em.remove(facturaPaypal);
        }
    }

}
