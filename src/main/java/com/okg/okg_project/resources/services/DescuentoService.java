/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Descuento;
import com.okg.okg_project.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Computadora
 */
public class DescuentoService implements IDescuentoService{
    private EntityManager em;
    
    public DescuentoService(){
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearDescuento(Descuento descuento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(descuento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Descuento> listarDescuento() {
        TypedQuery<Descuento> query = em.createQuery("SELECT FROM u DESCUENTO u", Descuento.class);
        return query.getResultList();
    }

    @Override
    public Descuento buscarDescuento(int idDescuento) {
        return em.find(Descuento.class, idDescuento);
    }

    @Override
    public void editarDescuento(Descuento descuento) {
        em.merge(descuento);
    }

    @Override
    public void eliminarDescuento(int idDescuento) {
        Descuento descuento = buscarDescuento(idDescuento);
        if (descuento != null) {
            em.remove(descuento);
        }
    }
    
}
