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
public class Usuario {

    public Usuario() {
    }
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nickname;
    private String email;
    private String contraseña;
    private String direccion;
    private String telefono;

    public Usuario(int idUsuario, String nickname, String email, String contraseña, String direccion, String telefono) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.email = email;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nickname=" + nickname + ", email=" + email + ", contrase\u00f1a=" + contraseña + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
    
    
}
