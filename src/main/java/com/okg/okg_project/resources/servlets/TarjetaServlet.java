/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.okg.okg_project.resources.servlets;

import com.okg.okg_project.resources.model.Tarjeta;
import com.okg.okg_project.resources.services.TarjetaService;

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
 * @author Omar
 */
@WebServlet(name = "TarjetaServlet", urlPatterns = {"/TarjetaServlet"})
@MultipartConfig
public class TarjetaServlet extends HttpServlet {

    private TarjetaService tarjetaService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.tarjetaService = new TarjetaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tarjeta> tarjetas = tarjetaService.listarTarjeta();
        tarjetas.forEach(t -> System.out.println(t));
        req.setAttribute("tarjetas", tarjetas);
        req.getRequestDispatcher("/pages/tarjetas.jsp").forward(req, resp); //cambiará
    }

    private void crearTarjeta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTarjeta = 0; //primary key == 0

        String numeroDeLaTarjeta = req.getParameter("numeroDeLaTarjeta");
        String nombreDelTitular = req.getParameter("nombreDelTitular");
        String fechaDeCaducidad = req.getParameter("fechaDeCaducidad");
        String codigoCVV = req.getParameter("codigoCVV");
        int idMetodoDePago = Integer.parseInt(req.getParameter("idMetodoDePago"));

        Tarjeta tarjeta = new Tarjeta(idTarjeta, numeroDeLaTarjeta, nombreDelTitular, fechaDeCaducidad, codigoCVV, idMetodoDePago);
        tarjetaService.crearTarjeta(tarjeta);
        resp.sendRedirect(req.getContextPath() + "/TarjetaServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearTarjeta(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }
    }

    private void editarTarjeta(int idTarjeta, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tarjeta tarjeta = tarjetaService.buscarTarjeta(idTarjeta);
        if (tarjeta != null) {
            String numeroDeLaTarjeta = req.getParameter("numeroDeLaTarjeta");
            String nombreDelTitular = req.getParameter("nombreDelTitular");
            String fechaDeCaducidad = req.getParameter("fechaDeCaducidad");
            String codigoCVV = req.getParameter("codigoCVV");
            int idMetodoDePago = Integer.parseInt(req.getParameter("idMetodoDePago"));

            tarjeta.setNumeroDeLaTarjeta(numeroDeLaTarjeta);
            tarjeta.setNombreDelTitular(nombreDelTitular);
            tarjeta.setFechaDeCaducidad(fechaDeCaducidad);
            tarjeta.setCodigoCVV(codigoCVV);
            tarjeta.setIdMetodoDePago(idMetodoDePago);

            tarjetaService.editarTarjeta(tarjeta);
            resp.sendRedirect(req.getContextPath() + "/TarjetaServlet");
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
                int idTarjeta = Integer.parseInt(pathParts[1]);
                editarTarjeta(idTarjeta, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarTarjeta(int idTarjeta, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tarjeta tarjeta = tarjetaService.buscarTarjeta(idTarjeta);
        if (tarjeta != null) {
            tarjetaService.eliminarTarjeta(idTarjeta);
            resp.sendRedirect(req.getContextPath() + "/TarjetaServlet");
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
                int idTarjeta = Integer.parseInt(pathParts[1]);
                eliminarTarjeta(idTarjeta, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
