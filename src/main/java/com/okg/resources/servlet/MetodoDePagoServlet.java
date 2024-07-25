/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.OKG.resources.servlet;

import com.OKG.resources.model.Juegos;
import com.OKG.resources.model.MetodoDePago;
import com.OKG.resources.model.Juegos;
import com.OKG.resources.services.JuegosService;
import com.OKG.resources.services.MetodoDePagoService;

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
@WebServlet(name = "MetodoDePagoServlet", urlPatterns = { "/MetodoDePagoServlet" })
@MultipartConfig
public class MetodoDePagoServlet extends HttpServlet {

    private MetodoDePagoService metodoDePagoService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.metodoDePagoService = new MetodoDePagoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MetodoDePago> metodoDePago = metodoDePagoService.listarMetodoDePago();
        metodoDePago.forEach(u -> System.out.println(u));
        req.setAttribute("metodoDePago", metodoDePago);
        req.getRequestDispatcher("/pages/shop.jsp").forward(req, resp); //cambiará
    }

    private void crearMetodoDePago(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idMetodoDePago = 0; //primary key == 0

        String tarjetaParam = req.getParameter("tarjeta");
        boolean tarjeta = tarjetaParam != null && tarjetaParam.equalsIgnoreCase("true");
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        if (tarjeta) {
            req.getParameter("true");
        } else {
            req.getParameter("false");
        }

        String paypalParam = req.getParameter("paypal");
        boolean paypal = paypalParam != null && paypalParam.equalsIgnoreCase("true");
        resp.setContentType("text/plain");
        if (tarjeta) {
            req.getParameter("true");
        } else {
            req.getParameter("false");
        }
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
  
        MetodoDePago metodoDePago = new MetodoDePago(idMetodoDePago, tarjeta, paypal, idUsuario);
        metodoDePagoService.crearMetodoDePago(metodoDePago);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearMetodoDePago(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }

    }

    private void editarMetodoDePago(int idMetodoDePago, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MetodoDePago MetodoDePago = metodoDePagoService.buscarMetodoDePago(idMetodoDePago);
        if (MetodoDePago != null) {
            String tarjetaParam = req.getParameter("tarjeta");
            boolean tarjeta = tarjetaParam != null && tarjetaParam.equalsIgnoreCase("true");
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            if (tarjeta) {
                req.getParameter("true");
            } else {
                req.getParameter("false");
            }
    
            String paypalParam = req.getParameter("paypal");
            boolean paypal = paypalParam != null && paypalParam.equalsIgnoreCase("true");
            resp.setContentType("text/plain");
            if (tarjeta) {
                req.getParameter("true");
            } else {
                req.getParameter("false");
            }
    
            int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
            
            MetodoDePago.setIdMetodoDePago(idMetodoDePago);
            MetodoDePago.setTarjeta(tarjeta);
            MetodoDePago.setPaypal(paypal);
            MetodoDePago.setIdUsuario(idUsuario);
            


            metodoDePagoService.buscarMetodoDePago(idMetodoDePago);

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
                int idMetodoDePago = Integer.parseInt(pathParts[1]);
                editarMetodoDePago(idMetodoDePago, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarMetodoDePago(int idMetodoDePago, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        MetodoDePago MetodoDePago  = metodoDePagoService.buscarMetodoDePago(idMetodoDePago);
        if (MetodoDePago != null) {
            metodoDePagoService.eliminarMetodoDePago(idMetodoDePago);
            resp.sendRedirect(req.getContextPath() + "/MetodoDePago/");
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
                int idMetodoDePago = Integer.parseInt(pathParts[1]);
                eliminarMetodoDePago(idMetodoDePago, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
