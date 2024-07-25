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
public class Carrito {

    public Carrito() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrito;
    private Double subtotal;
    private Double total;
    private Double descuento;
    private int idJuego;
    private int idUsuario;
    private int idCodigoDescuento;

    public Carrito(int idCarrito, Double subtotal, Double total, Double descuento, int idJuego, int idUsuario, int idCodigoDescuento) {
        this.idCarrito = idCarrito;
        this.subtotal = subtotal;
        this.total = total;
        this.descuento = descuento;
        this.idJuego = idJuego;
        this.idUsuario = idUsuario;
        this.idCodigoDescuento = idCodigoDescuento;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCodigoDescuento() {
        return idCodigoDescuento;
    }

    public void setIdCodigoDescuento(int idCodigoDescuento) {
        this.idCodigoDescuento = idCodigoDescuento;
    }

    @Override
    public String toString() {
        return "Carrito{" + "idCarrito=" + idCarrito + ", subtotal=" + subtotal + ", total=" + total + ", descuento=" + descuento + ", idJuego=" + idJuego + ", idUsuario=" + idUsuario + ", idCodigoDescuento=" + idCodigoDescuento + '}';
    }
    
    
}
