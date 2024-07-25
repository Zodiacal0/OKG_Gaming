/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.OKG.resources.servlet;

import com.OKG.resources.model.Juegos;
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
import com.OKG.resources.services.JuegosService;

/**
 *
 * @author Javier
 */
@WebServlet(name = "JuegosServlet", urlPatterns = { "/JuegoServlet" })
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
        String telefono = req.getParameter("descripcion");

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
            String telefono = req.getParameter("descripcion");

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
