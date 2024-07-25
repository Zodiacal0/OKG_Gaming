/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Carrito;
import com.okg.okg_project.resources.services.ICarritoService;
import com.okg.okg_project.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Luis
 */
public class CarritoService implements ICarritoService {
    private EntityManager em;
    public CarritoService(){
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearCarrito(Carrito carrito) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(carrito);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Carrito> listarCarrito() {
TypedQuery<Carrito> query = em.createQuery("SELECT FROM u CARRITO u", Carrito.class);
        return query.getResultList();
    }

    @Override
    public Carrito buscarCarrito(int idCarrito) {
return em.find(Carrito.class, idCarrito);
    }

    @Override
    public void editarCarrito(Carrito carrito) {
        em.merge(carrito);
    }

    @Override
    public void eliminarCarrito(int idCarrito) {
        Carrito carrito = buscarCarrito(idCarrito);
        if (carrito != null) {
            em.remove(carrito);
        }
    }
    
}
