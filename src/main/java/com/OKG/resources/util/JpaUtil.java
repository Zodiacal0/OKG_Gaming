/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Javier
 */
public class JpaUtil {
    private static final EntityManagerFactory em = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try{
            return Persistence.createEntityManagerFactory("DB_OKGShop");
        }catch(Throwable e){
            throw new ExceptionInInitializerError(e); 
        }
    }
    
    public static EntityManager getEntityManager(){
        return em.createEntityManager();
    }
    
    public static void close(){
        em.close();
    }
}
