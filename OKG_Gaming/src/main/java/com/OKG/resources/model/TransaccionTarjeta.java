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
public class TransaccionTarjeta {

    public TransaccionTarjeta() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccionTarjeta;
    private Double monto;
    private String fecha;
    private int idTarjeta;

    public TransaccionTarjeta(int idTransaccionTarjeta, Double monto, String fecha, int idTarjeta) {
        this.idTransaccionTarjeta = idTransaccionTarjeta;
        this.monto = monto;
        this.fecha = fecha;
        this.idTarjeta = idTarjeta;
    }

    public int getIdTransaccionTarjeta() {
        return idTransaccionTarjeta;
    }

    public void setIdTransaccionTarjeta(int idTransaccionTarjeta) {
        this.idTransaccionTarjeta = idTransaccionTarjeta;
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

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    @Override
    public String toString() {
        return "TransaccionTarjeta{" + "idTransaccionTarjeta=" + idTransaccionTarjeta + ", monto=" + monto + ", fecha=" + fecha + ", idTarjeta=" + idTarjeta + '}';
    }
    
    
}
