/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.OKG.resources.services;

import com.OKG.resources.model.Usuario;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IUsuarioService {
    public void crearUsuario(Usuario usuario);
    
    public List<Usuario>listarUsuario();
    
    public Usuario buscarUsuario(int idUsuario);
    
    public void  editarUsuario(Usuario usuario);
    
    public void eliminarUsuario(int idUsuario);
    
}
