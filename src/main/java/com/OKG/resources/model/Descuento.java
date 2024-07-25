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
public class Descuento {

    public Descuento() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCodigoDescuento;
    private Double valorDescuento;
    private String descripcion;
    private String aplicacion;
    private String fechaDeCaducidad;

    public Descuento(int idCodigoDescuento, Double valorDescuento, String descripcion, String aplicacion, String fechaDeCaducidad) {
        this.idCodigoDescuento = idCodigoDescuento;
        this.valorDescuento = valorDescuento;
        this.descripcion = descripcion;
        this.aplicacion = aplicacion;
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    public int getIdCodigoDescuento() {
        return idCodigoDescuento;
    }

    public void setIdCodigoDescuento(int idCodigoDescuento) {
        this.idCodigoDescuento = idCodigoDescuento;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }

    public void setFechaDeCaducidad(String fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }

    @Override
    public String toString() {
        return "Descuento{" + "idCodigoDescuento=" + idCodigoDescuento + ", valorDescuento=" + valorDescuento + ", descripcion=" + descripcion + ", aplicacion=" + aplicacion + ", fechaDeCaducidad=" + fechaDeCaducidad + '}';
    }
    
    
}
