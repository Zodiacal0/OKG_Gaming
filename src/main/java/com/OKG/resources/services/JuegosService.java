/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Juegos;
import com.OKG.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class JuegosService implements IJuegoService {
    private EntityManager em;
    public JuegosService(){
        this.em= JpaUtil.getEntityManager();
    }

    @Override
    public void crearJuego(Juegos juego) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(juego);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Juegos> listarJuego() {
 TypedQuery<Juegos> query = em.createQuery("SELECT FROM u JUEGOS u", Juegos.class);
        return query.getResultList();
    }

    @Override
    public Juegos buscarJuego(int idJuego) {
        return em.find(Juegos.class, idJuego);
    }

    @Override
    public void editarJuego(Juegos juego) {
        em.merge(juego);
    }

    @Override
    public void eliminarJuego(int idJuego) {
        Juegos juego = buscarJuego(idJuego);
        if (juego != null) {
            em.remove(juego);
        }
    }
}
