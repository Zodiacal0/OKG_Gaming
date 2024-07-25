/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Usuario;
import com.okg.okg_project.resources.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Javier
 * @author  Luis
 */
public class UsuarioService implements IUsuarioService {

    private EntityManager em;

    public UsuarioService() {
        this.em = JpaUtil.getEntityManager();
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> listarUsuario() {
        TypedQuery<Usuario> query = em.createQuery("SELECT FROM u USUARIO u", Usuario.class);
        return query.getResultList();
    }

    @Override
    public Usuario buscarUsuario(int idUsuario) {
        return em.find(Usuario.class, idUsuario);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario != null) {
            em.remove(usuario);
        }
    }

}
