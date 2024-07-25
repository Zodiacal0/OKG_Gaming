/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Foro;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ForoService implements IForoService {

    private EntityManager em;

    public ForoService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearForo(Foro foro) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(foro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Foro> listarForo() {
        TypedQuery<Foro> query = em.createQuery("SELECT FROM u FORO u", Foro.class);
        return query.getResultList();
    }

    @Override
    public Foro buscarForo(int idForo) {
        return em.find(Foro.class, idForo);
    }

    @Override
    public void editarForo(Foro foro) {
        em.merge(foro);
    }

    @Override
    public void eliminarForo(int idForo) {
        Foro foro = buscarForo(idForo);
        if (foro != null) {
            em.remove(foro);
        }
    }

}
