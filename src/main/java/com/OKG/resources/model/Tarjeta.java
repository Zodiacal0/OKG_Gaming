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
public class Tarjeta {

    public Tarjeta() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;
    private String numeroDeLaTarjeta;
    private String nombreDelTitular;
    private String fechaDeCaducidad;
    private String codigoCVV;
    private int idMetodoDePago;

    public Tarjeta(int idTarjeta, String numeroDeLaTarjeta, String nombreDelTitular, String fechaDeCaducidad, String codigoCVV, int idMetodoDePago) {
        this.idTarjeta = idTarjeta;
        this.numeroDeLaTarjeta = numeroDeLaTarjeta;
        this.nombreDelTitular = nombreDelTitular;
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.codigoCVV = codigoCVV;
        this.idMetodoDePago = idMetodoDePago;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNumeroDeLaTarjeta() {
        return numeroDeLaTarjeta;
    }

    public void setNumeroDeLaTarjeta(String numeroDeLaTarjeta) {
        this.numeroDeLaTarjeta = numeroDeLaTarjeta;
    }

    public String getNombreDelTitular() {
        return nombreDelTitular;
    }

    public void setNombreDelTitular(String nombreDelTitular) {
        this.nombreDelTitular = nombreDelTitular;
    }

    public String getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public void setFechaDeCaducidad(String fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public String getCodigoCVV() {
        return codigoCVV;
    }

    public void setCodigoCVV(String codigoCVV) {
        this.codigoCVV = codigoCVV;
    }

    public int getIdMetodoDePago() {
        return idMetodoDePago;
    }

    public void setIdMetodoDePago(int idMetodoDePago) {
        this.idMetodoDePago = idMetodoDePago;
    }

    @Override
    public String toString() {
        return "MetodoDePago{" + "idTarjeta=" + idTarjeta + ", numeroDeLaTarjeta=" + numeroDeLaTarjeta + ", nombreDelTitular=" + nombreDelTitular + ", fechaDeCaducidad=" + fechaDeCaducidad + ", codigoCVV=" + codigoCVV + ", idMetodoDePago=" + idMetodoDePago + '}';
    }
    
    
    
}
