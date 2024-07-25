/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Desarrolladora;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class DesarrolladoraService implements IDesarrolladoraService {

    private EntityManager em;

    public DesarrolladoraService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearDesarrolladora(Desarrolladora desarrolladora) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(desarrolladora);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Desarrolladora> listarDesarrolladora() {
        TypedQuery<Desarrolladora> query = em.createQuery("SELECT FROM u DESARROLLADORA u", Desarrolladora.class);
        return query.getResultList();
    }

    @Override
    public Desarrolladora buscarDesarrolladora(int idDesarrolladora) {
        return em.find(Desarrolladora.class, idDesarrolladora);
    }

    @Override
    public void editarDesarrolladora(Desarrolladora desarrolladora) {
       em.merge(desarrolladora);
    }

    @Override
    public void eliminarDesarrolladora(int idDesarrolladora) {
        Desarrolladora desarrolladora = buscarDesarrolladora(idDesarrolladora);
        if (desarrolladora != null) {
            em.remove(desarrolladora);
        }
    }

}
