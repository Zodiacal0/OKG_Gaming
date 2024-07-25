/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.okg.okg_project.resources.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Javier
 */
public class Paypal {

    public Paypal() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaypal;
    private String email;
    private int idMetodoDePago;

    public Paypal(int idPaypal, String email, int idMetodoDePago) {
        this.idPaypal = idPaypal;
        this.email = email;
        this.idMetodoDePago = idMetodoDePago;
    }

    public int getIdPaypal() {
        return idPaypal;
    }

    public void setIdPaypal(int idPaypal) {
        this.idPaypal = idPaypal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdMetodoDePago() {
        return idMetodoDePago;
    }

    public void setIdMetodoDePago(int idMetodoDePago) {
        this.idMetodoDePago = idMetodoDePago;
    }

    @Override
    public String toString() {
        return "Paypal{" + "idPaypal=" + idPaypal + ", email=" + email + ", idMetodoDePago=" + idMetodoDePago + '}';
    }
    
    
}
