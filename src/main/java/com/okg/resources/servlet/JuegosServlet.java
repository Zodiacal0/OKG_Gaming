/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.OKG.resources.servlet;

import com.OKG.resources.model.Juegos;
import com.OKG.resources.model.Juegos;
import com.OKG.resources.services.JuegosService;
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
@WebServlet(name = "JuegosServlet", urlPatterns = { "/JuegosServlet" })
@MultipartConfig
public class JuegosServlet extends HttpServlet {

    private JuegosService juegosService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.juegosService = new JuegosService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Juegos> juegos = juegosService.listarJuego();
        juegos.forEach(u -> System.out.println(u));
        req.setAttribute("juegos", juegos);
        req.getRequestDispatcher("/pages/shop.jsp").forward(req, resp);
    }

    private void crearJuegos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idJuego = 0; 
        String nombre = req.getParameter("nombre");
        String categoria = req.getParameter("cagetgoria");
        int clasificacionPEGI = Integer.parseInt(req.getParameter("clasificacionPEGI"));
        String clasificacionESRB = req.getParameter("clasificacionESRB");
        Double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String descripcion = req.getParameter("descripcion");
        int idDesarrolladora = Integer.parseInt(req.getParameter("idDesarrolladora"));
  
        Juegos Juegos = new Juegos(idJuego, nombre, categoria, clasificacionPEGI, clasificacionESRB, precio, stock, descripcion, idDesarrolladora);
        juegosService.crearJuego(Juegos);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearJuegos(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }

    }

    private void editarJuegos(int idJuego, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Juegos Juegos = juegosService.buscarJuego(idJuego);
        if (Juegos != null) {
            String nombre = req.getParameter("nombre");
            String categoria = req.getParameter("cagetgoria");
            int clasificacionPEGI = Integer.parseInt(req.getParameter("clasificacionPEGI"));
            String clasificacionESRB = req.getParameter("clasificacionESRB");
            Double precio = Double.parseDouble(req.getParameter("precio"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            String descripcion = req.getParameter("descripcion");
            int idDesarrolladora = Integer.parseInt(req.getParameter("idDesarrolladora"));

            Juegos.setNombre(nombre);
            Juegos.setCategoria(categoria);
            Juegos.setClasificacionPEGI(clasificacionPEGI);
            Juegos.setClasificacionESRB(clasificacionESRB);
            Juegos.setPrecio(precio);
            Juegos.setStock(stock);
            Juegos.setDescripcion(descripcion);
            Juegos.setIdDesarrolladora(idDesarrolladora);
            


            juegosService.buscarJuego(idJuego);

            resp.sendRedirect(req.getContextPath() + "/Juegos/");
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
                int idJuego = Integer.parseInt(pathParts[1]);
                editarJuegos(idJuego, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarJuegos(int idJuego, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Juegos Juegos  = juegosService.buscarJuego(idJuego);
        if (Juegos != null) {
            juegosService.eliminarJuego(idJuego);
            resp.sendRedirect(req.getContextPath() + "/Juegos/");
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
                int idJuego = Integer.parseInt(pathParts[1]);
                eliminarJuegos(idJuego, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
