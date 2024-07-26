/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.OKG.resources.servlet;

import com.OKG.resources.model.Usuario;
import com.OKG.resources.services.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
@MultipartConfig
public class UsuarioServlet extends HttpServlet {

    private UsuarioService usuarioService;
    
    @Override
    public void init() throws ServletException{
        super.init();
        this.usuarioService = new UsuarioService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        List<Usuario> usuario = usuarioService.listarUsuario();
        usuario.forEach(u -> System.out.println(u));
        req.setAttribute("usuario", usuario);
        req.getRequestDispatcher("/listar-usuario/");
    }
}
