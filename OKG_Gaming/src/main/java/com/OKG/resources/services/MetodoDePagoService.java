/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.MetodoDePago;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class MetodoDePagoService implements IMetodoDePagoService {
    
    private EntityManager em;
    
    public MetodoDePagoService() {
        this.em = JpaUtil.getEntityManager();
    }
    
    @Override
    public void crearMetodoDePago(MetodoDePago metodoDePago) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(metodoDePago);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    @Override
    public List<MetodoDePago> listarMetodoDePago() {
        TypedQuery<MetodoDePago> query = em.createQuery("SELECT FROM u METODODEPAGO u", MetodoDePago.class);
        return query.getResultList();
    }
    
    @Override
    public MetodoDePago buscarMetodoDePago(int idMetodoDePago) {
        return em.find(MetodoDePago.class, idMetodoDePago);
    }
    
    @Override
    public void editarMetodoDePago(MetodoDePago metodoDePago) {
        em.merge(metodoDePago);
    }
    
    @Override
    public void eliminarMetodoDePago(int idMetodoDePago) {
        MetodoDePago metodoDePago = buscarMetodoDePago(idMetodoDePago);
        if (metodoDePago != null) {
            em.remove(metodoDePago);
        }
    }
    
}
