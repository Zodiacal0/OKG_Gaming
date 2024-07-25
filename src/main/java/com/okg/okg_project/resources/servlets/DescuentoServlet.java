package com.okg.okg_project.resources.servlets;

import com.okg.okg_project.resources.model.Descuento;
import com.okg.okg_project.resources.services.DescuentoService;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DescuentoServlet", urlPatterns = {"/DescuentoServlet"})
@MultipartConfig
public class DescuentoServlet extends HttpServlet {

    private DescuentoService descuentoService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.descuentoService = new DescuentoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Descuento> descuento = descuentoService.listarDescuento();
        descuento.forEach(u -> System.out.println(u));
        req.setAttribute("descuento", descuento);
        req.getRequestDispatcher("/pages/shop.jsp").forward(req, resp);
    }

    private void crearDescuento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCodigoDescuento = 0;
        Double valorDescuento = Double.parseDouble(req.getParameter("valorDescuento"));
        String descripcion = req.getParameter("descripcion");
        String aplicacion = req.getParameter("aplicacion");
        String fechaDeCaducidad = req.getParameter("fechaDeCaducidad");

        Descuento descuento = new Descuento(idCodigoDescuento, valorDescuento, descripcion, aplicacion, fechaDeCaducidad);
        descuentoService.crearDescuento(descuento);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearDescuento(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }
    }

    private void editarDescuento(int idCodigoDescuento, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Descuento descuento = descuentoService.buscarDescuento(idCodigoDescuento);
        if (descuento != null) {
            Double valorDescuento = Double.parseDouble(req.getParameter("valorDescuento"));
            String descripcion = req.getParameter("descripcion");
            String aplicacion = req.getParameter("aplicacion");
            String fechaDeCaducidad = req.getParameter("fechaDeCaducidad");

            descuento.setValorDescuento(valorDescuento);
            descuento.setDescripcion(descripcion);
            descuento.setAplicacion(aplicacion);
            descuento.setFechaDeCaducidad(fechaDeCaducidad);

            descuentoService.editarDescuento(descuento);

            resp.sendRedirect(req.getContextPath() + "/Descuento/");
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
                int idCodigoDescuento = Integer.parseInt(pathParts[1]);
                editarDescuento(idCodigoDescuento, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarDescuento(int idCodigoDescuento, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Descuento descuento  = descuentoService.buscarDescuento(idCodigoDescuento);
        if (descuento != null) {
            descuentoService.eliminarDescuento(idCodigoDescuento);
            resp.sendRedirect(req.getContextPath() + "/Descuento/");
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
                int idCodigoDescuento = Integer.parseInt(pathParts[1]);
                eliminarDescuento(idCodigoDescuento, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
}
