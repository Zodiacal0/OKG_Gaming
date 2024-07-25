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
public class Desarrolladora {

    public Desarrolladora() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDesarrolladora;
    private String nombre;
    private String nacionalidad;
    private String telefono;
    private String email;

    public Desarrolladora(int idDesarrolladora, String nombre, String nacionalidad, String telefono, String email) {
        this.idDesarrolladora = idDesarrolladora;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdDesarrolladora() {
        return idDesarrolladora;
    }

    public void setIdDesarrolladora(int idDesarrolladora) {
        this.idDesarrolladora = idDesarrolladora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Desarrolladora{" + "idDesarrolladora=" + idDesarrolladora + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
}
