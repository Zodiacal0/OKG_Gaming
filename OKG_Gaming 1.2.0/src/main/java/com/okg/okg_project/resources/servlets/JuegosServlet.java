package com.okg.okg_project.resources.servlets;

import com.okg.okg_project.resources.model.Juegos;
import com.okg.okg_project.resources.services.JuegosService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "JuegosServlet", urlPatterns = {"/JuegosServlet"})
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
        String action = req.getParameter("action");

        if (action == null) {
            action = "null";
        }
        switch (action) {
            case "handleAction1":
                handleAction1(req, resp);
                break;
            case "handleAction2":
                handleAction2(req, resp);
                break;
            case "handleAction3":
                handleAction3(req,resp);
                break;
            case "handleAction4":
                handleAction4(req,resp);
            default:
                break;
        }
    }

    private void handleAction1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath() + "/pages/deluxe-games.jsp");
    }

    private void handleAction2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath() + "shop.jsp");
    }
    private void handleAction3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath() + "/pages/nintendo-games.jsp");
    }
    private void handleAction4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(req.getContextPath() + "/pages/play-games.jsp");
    }

    private void crearJuegos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idJuego = 0;
        String nombre = req.getParameter("nombre");
        String categoria = req.getParameter("categoria");
        int clasificacionPEGI = Integer.parseInt(req.getParameter("clasificacionPEGI"));
        String clasificacionESRB = req.getParameter("clasificacionESRB");
        Double precio = Double.parseDouble(req.getParameter("precio"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String descripcion = req.getParameter("descripcion");
        int idDesarrolladora = Integer.parseInt(req.getParameter("idDesarrolladora"));

        Juegos juegos = new Juegos(idJuego, nombre, categoria, clasificacionPEGI, clasificacionESRB, precio, stock, descripcion, idDesarrolladora);
        juegosService.crearJuego(juegos);
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
        Juegos juegos = juegosService.buscarJuego(idJuego);
        if (juegos != null) {
            String nombre = req.getParameter("nombre");
            String categoria = req.getParameter("categoria");
            int clasificacionPEGI = Integer.parseInt(req.getParameter("clasificacionPEGI"));
            String clasificacionESRB = req.getParameter("clasificacionESRB");
            Double precio = Double.parseDouble(req.getParameter("precio"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            String descripcion = req.getParameter("descripcion");
            int idDesarrolladora = Integer.parseInt(req.getParameter("idDesarrolladora"));

            juegos.setNombre(nombre);
            juegos.setCategoria(categoria);
            juegos.setClasificacionPEGI(clasificacionPEGI);
            juegos.setClasificacionESRB(clasificacionESRB);
            juegos.setPrecio(precio);
            juegos.setStock(stock);
            juegos.setDescripcion(descripcion);
            juegos.setIdDesarrolladora(idDesarrolladora);

            juegosService.editarJuego(juegos);

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
        Juegos juegos  = juegosService.buscarJuego(idJuego);
        if (juegos != null) {
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
