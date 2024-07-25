package com.okg.okg_project.resources.servlets;

import com.okg.okg_project.resources.model.Desarrolladora;
import com.okg.okg_project.resources.services.DesarrolladoraService;
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
 * @author Erick
 */

@WebServlet(name = "DesarrolladoraServlet", urlPatterns = {"/DesarrolladoraServlet"})
@MultipartConfig
public class DesarrolladoraServlet extends HttpServlet {

    private DesarrolladoraService desarrolladoraService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.desarrolladoraService = new DesarrolladoraService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Desarrolladora> desarrolladora = desarrolladoraService.listarDesarrolladora();
        desarrolladora.forEach(u -> System.out.println(u));
        req.setAttribute("desarrolladora", desarrolladora);
        req.getRequestDispatcher("/pages/shop.jsp").forward(req, resp);
    }

    private void crearDesarrolladora(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDesarrolladora = 0;
        String nombre = req.getParameter("nombre");
        String nacionalidad = req.getParameter("nacionalidad");
        String telefono = req.getParameter("telefono");
        String email = req.getParameter("email");

        Desarrolladora desarrolladora = new Desarrolladora(idDesarrolladora, nombre, nacionalidad, telefono, email);
        desarrolladoraService.crearDesarrolladora(desarrolladora);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearDesarrolladora(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }
    }

    private void editarDesarrolladora(int idDesarrolladora, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Desarrolladora desarrolladora = desarrolladoraService.buscarDesarrolladora(idDesarrolladora);
        if (desarrolladora != null) {
            String nombre = req.getParameter("nombre");
            String nacionalidad = req.getParameter("nacionalidad");
            String telefono = req.getParameter("telefono");
            String email = req.getParameter("email");

            desarrolladora.setNombre(nombre);
            desarrolladora.setNacionalidad(nacionalidad);
            desarrolladora.setTelefono(telefono);
            desarrolladora.setEmail(email);

            desarrolladoraService.editarDesarrolladora(desarrolladora);

            resp.sendRedirect(req.getContextPath() + "/Desarrolladora/");
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
                int idDesarrolladora = Integer.parseInt(pathParts[1]);
                editarDesarrolladora(idDesarrolladora, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarDesarrolladora(int idDesarrolladora, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Desarrolladora desarrolladora  = desarrolladoraService.buscarDesarrolladora(idDesarrolladora);
        if (desarrolladora != null) {
            desarrolladoraService.eliminarDesarrolladora(idDesarrolladora);
            resp.sendRedirect(req.getContextPath() + "/Desarrolladora/");
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
                int idDesarrolladora = Integer.parseInt(pathParts[1]);
                eliminarDesarrolladora(idDesarrolladora, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
}
