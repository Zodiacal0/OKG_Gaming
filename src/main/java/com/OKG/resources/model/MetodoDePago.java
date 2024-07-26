/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.OKG.resources.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Javier
 */
public class MetodoDePago {

    public MetodoDePago() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodoDePago;
    private boolean tarjeta;
    private boolean paypal;
    private int idUsuario;

    public MetodoDePago(int idMetodoDePago, boolean tarjeta, boolean paypal, int idUsuario) {
        this.idMetodoDePago = idMetodoDePago;
        this.tarjeta = tarjeta;
        this.paypal = paypal;
        this.idUsuario = idUsuario;
    }

    public int getIdMetodoDePago() {
        return idMetodoDePago;
    }

    public void setIdMetodoDePago(int idMetodoDePago) {
        this.idMetodoDePago = idMetodoDePago;
    }

    public boolean isTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    public boolean isPaypal() {
        return paypal;
    }

    public void setPaypal(boolean paypal) {
        this.paypal = paypal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "MetodoDePago{" + "idMetodoDePago=" + idMetodoDePago + ", tarjeta=" + tarjeta + ", paypal=" + paypal + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
