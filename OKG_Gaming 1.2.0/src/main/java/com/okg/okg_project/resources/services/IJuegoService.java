/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.okg.okg_project.resources.services;

import com.okg.okg_project.resources.model.Juegos;
import java.util.List;

/**
 *
 * @author Javier
 */
public interface IJuegoService {
    public void crearJuego(Juegos juego);
    
    public List<Juegos> listarJuego();
    
    public Juegos buscarJuego(int idJuego);
    
    public void editarJuego(Juegos juego);
    
    public void eliminarJuego(int idJuego);
}
