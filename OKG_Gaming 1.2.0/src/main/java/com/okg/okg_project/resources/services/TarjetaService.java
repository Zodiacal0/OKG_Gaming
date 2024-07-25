/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Tarjeta;
import com.okg.okg_project.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class TarjetaService implements ITarjetaService {

    private EntityManager em;
     public TarjetaService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearTarjeta(Tarjeta tarjeta) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(tarjeta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Tarjeta> listarTarjeta() {
        TypedQuery<Tarjeta> query = em.createQuery("SELECT FROM u TRAJETA u", Tarjeta.class);
        return query.getResultList();
    }

    @Override
    public Tarjeta buscarTarjeta(int idTarjeta) {
        return em.find(Tarjeta.class, idTarjeta);
    }

    @Override
    public void editarTarjeta(Tarjeta tarjeta) {
        em.merge(tarjeta);
    }

    @Override
    public void eliminarTarjeta(int idTarjeta) {
        Tarjeta tarjeta = buscarTarjeta(idTarjeta);
        if (tarjeta != null) {
            em.remove(tarjeta);
        }
    }

}
