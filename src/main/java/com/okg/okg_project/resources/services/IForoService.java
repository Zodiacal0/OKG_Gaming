/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Foro;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IForoService {
    public void crearForo(Foro foro);
    
    public List<Foro> listarForo();
    
    public Foro buscarForo(int idForo);
    
    public void editarForo(Foro foro);
    
    public void eliminarForo(int idForo);
}
