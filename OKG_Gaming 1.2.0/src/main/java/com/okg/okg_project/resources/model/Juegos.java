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
public class Juegos {

    public Juegos() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJuego;
    private String nombre;
    private String categoria;
    private int clasificacionPEGI;
    private String clasificacionESRB;
    private Double precio;
    private int stock;
    private String descripcion;
    private int idDesarrolladora;

    public Juegos(int idJuego, String nombre, String categoria, int clasificacionPEGI, String clasificacionESRB, Double precio, int stock, String descripcion, int idDesarrolladora) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.categoria = categoria;
        this.clasificacionPEGI = clasificacionPEGI;
        this.clasificacionESRB = clasificacionESRB;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.idDesarrolladora = idDesarrolladora;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getClasificacionPEGI() {
        return clasificacionPEGI;
    }

    public void setClasificacionPEGI(int clasificacionPEGI) {
        this.clasificacionPEGI = clasificacionPEGI;
    }

    public String getClasificacionESRB() {
        return clasificacionESRB;
    }

    public void setClasificacionESRB(String clasificacionESRB) {
        this.clasificacionESRB = clasificacionESRB;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdDesarrolladora() {
        return idDesarrolladora;
    }

    public void setIdDesarrolladora(int idDesarrolladora) {
        this.idDesarrolladora = idDesarrolladora;
    }

    @Override
    public String toString() {
        return "Juegos{" + "idJuego=" + idJuego + ", nombre=" + nombre + ", categoria=" + categoria + ", clasificacionPEGI=" + clasificacionPEGI + ", clasificacionESRB=" + clasificacionESRB + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", idDesarrolladora=" + idDesarrolladora + '}';
    }
    
    
}
