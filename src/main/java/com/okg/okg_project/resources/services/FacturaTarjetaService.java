/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.FacturaTarjeta;
import com.okg.okg_project.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class FacturaTarjetaService implements IFacturaTarjetaService{
private EntityManager em;

public FacturaTarjetaService(){
    this.em = JpaUtil.getEntityManager();
}

    @Override
    public void crearFacturaTarjeta(FacturaTarjeta facturaTarjeta) {
EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(facturaTarjeta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<FacturaTarjeta> listarFacturaTarjeta() {
   TypedQuery<FacturaTarjeta> query = em.createQuery("SELECT FROM u FACTURATARJETA u", FacturaTarjeta.class);
        return query.getResultList();
    }

    @Override
    public FacturaTarjeta buscarFacturaTarjeta(int idFacturaTarjeta) {
        return em.find(FacturaTarjeta.class, idFacturaTarjeta);
    }

    @Override
    public void editarFacturaTarjeta(FacturaTarjeta facturaTarjeta) {
        em.merge(facturaTarjeta);
    }

    @Override
    public void eliminarFacturaTarjeta(int idFacturaTarjeta) {
        FacturaTarjeta facturaTarjeta = buscarFacturaTarjeta(idFacturaTarjeta);
        if (facturaTarjeta != null) {
            em.remove(facturaTarjeta);
        }
    }
    
}
