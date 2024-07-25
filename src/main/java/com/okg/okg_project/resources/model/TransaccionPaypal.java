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
public class TransaccionPaypal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccionPaypal;
    private Double monto;
    private String fecha;
    private int idPaypal;

    public TransaccionPaypal(int idTransaccionPaypal, Double monto, String fecha, int idPaypal) {
        this.idTransaccionPaypal = idTransaccionPaypal;
        this.monto = monto;
        this.fecha = fecha;
        this.idPaypal = idPaypal;
    }

    public int getIdTransaccionPaypal() {
        return idTransaccionPaypal;
    }

    public void setIdTransaccionPaypal(int idTransaccionPaypal) {
        this.idTransaccionPaypal = idTransaccionPaypal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPaypal() {
        return idPaypal;
    }

    public void setIdPaypal(int idPaypal) {
        this.idPaypal = idPaypal;
    }

    @Override
    public String toString() {
        return "TransaccionPaypal{" + "idTransaccionPaypal=" + idTransaccionPaypal + ", monto=" + monto + ", fecha=" + fecha + ", idPaypal=" + idPaypal + '}';
    }
    
}
