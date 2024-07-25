/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.okg.okg_project.resources.servlets;

import com.okg.okg_project. resources.model.Usuario;
import com.okg.okg_project.resources.services.UsuarioService;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Javier
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = { "/UsuarioServlet" })
@MultipartConfig
public class UsuarioServlet extends HttpServlet {

    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.usuarioService = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuario = usuarioService.listarUsuario();
        usuario.forEach(u -> System.out.println(u));
        req.setAttribute("usuario", usuario);
        req.getRequestDispatcher("/pages/shop.jsp").forward(req, resp);
    }

    private void crearUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = 0;
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");
        String contraseña = req.getParameter("contraseña");
        String direccion = req.getParameter("direccion");
        String telefono = req.getParameter("telefono");

        Usuario usuario = new Usuario(idUsuario, nickname, email, contraseña, direccion, telefono);
        usuarioService.crearUsuario(usuario);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearUsuario(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }

    }

    private void editarUsuario(int idUsuario, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        if (usuario != null) {
            String nickname = req.getParameter("nickname");
            String email = req.getParameter("email");
            String contraseña = req.getParameter("contraseña");
            String direccion = req.getParameter("direccion");
            String telefono = req.getParameter("telefono");

            usuario.setNickname(nickname);
            usuario.setEmail(email);
            usuario.setContraseña(contraseña);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);

            usuarioService.editarUsuario(usuario);

            resp.sendRedirect(req.getContextPath() + "/usuario/");
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo != null && !pathInfo.equals("/")) {
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length == 2) {
                int UsuarioId = Integer.parseInt(pathParts[1]);
                editarUsuario(UsuarioId, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarUsuario(int usuarioId, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Usuario usuario  = usuarioService.buscarUsuario(usuarioId);
        if (usuario != null) {
            usuarioService.eliminarUsuario(usuarioId);
            resp.sendRedirect(req.getContextPath() + "/usuario/");
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo != null && !pathInfo.equals("/")) {
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length == 2) {
                int usuarioId = Integer.parseInt(pathParts[1]);
                eliminarUsuario(usuarioId, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

} 
