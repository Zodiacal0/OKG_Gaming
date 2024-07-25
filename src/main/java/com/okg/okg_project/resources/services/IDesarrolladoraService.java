/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Desarrolladora;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IDesarrolladoraService {
    public void crearDesarrolladora(Desarrolladora desarrolladora);
    
    public List<Desarrolladora> listarDesarrolladora();
    
    public Desarrolladora buscarDesarrolladora(int idDesarrolladora);
    
    public void editarDesarrolladora(Desarrolladora desarrolladora);
    
    public void eliminarDesarrolladora(int idDesarrolladora);
}
