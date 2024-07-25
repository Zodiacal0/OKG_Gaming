package com.okg.okg_project.resources.servlets;

import com.okg.okg_project.resources.model.TransaccionTarjeta;
import com.okg.okg_project.resources.services.TransaccionTarjetaService;
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

@WebServlet(name = "TransaccionTarjetaServlet", urlPatterns = {"/TransaccionTarjetaServlet"})
@MultipartConfig
public class TransaccionTarjetaServlet extends HttpServlet {

    private TransaccionTarjetaService transaccionTarjetaService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.transaccionTarjetaService = new TransaccionTarjetaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TransaccionTarjeta> transaccionTarjeta = transaccionTarjetaService.listarTransaccionTarjeta();
        transaccionTarjeta.forEach(u -> System.out.println(u));
        req.setAttribute("transaccionTarjeta", transaccionTarjeta);
        req.getRequestDispatcher("/pages/shop.jsp").forward(req, resp);
    }

    private void crearTransaccionTarjeta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTransaccionTarjeta = 0;
        Double monto = Double.parseDouble(req.getParameter("monto"));
        String fecha = req.getParameter("fecha");
        int idTarjeta = Integer.parseInt(req.getParameter("idTarjeta"));

        TransaccionTarjeta transaccionTarjeta = new TransaccionTarjeta(idTransaccionTarjeta, monto, fecha, idTarjeta);
        transaccionTarjetaService.crearTransaccionTarjeta(transaccionTarjeta);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearTransaccionTarjeta(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }
    }

    private void editarTransaccionTarjeta(int idTransaccionTarjeta, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            TransaccionTarjeta transaccionTarjeta = transaccionTarjetaService.buscarTransaccionTarjeta(idTransaccionTarjeta);
        if (transaccionTarjeta != null) {
            Double monto = Double.parseDouble(req.getParameter("monto"));
            String fecha = req.getParameter("fecha");
            int idTarjeta = Integer.parseInt(req.getParameter("idTarjeta"));

            transaccionTarjeta.setMonto(monto);
            transaccionTarjeta.setFecha(fecha);
            transaccionTarjeta.setIdTarjeta(idTarjeta);

            transaccionTarjetaService.editarTransaccionTarjeta(transaccionTarjeta);

            resp.sendRedirect(req.getContextPath() + "/TransaccionTarjeta/");
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
                int idTransaccionTarjeta = Integer.parseInt(pathParts[1]);
                editarTransaccionTarjeta(idTransaccionTarjeta, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarTransaccionTarjeta(int idTransaccionTarjeta, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        TransaccionTarjeta desarrolladora  = transaccionTarjetaService.buscarTransaccionTarjeta(idTransaccionTarjeta);
        if (desarrolladora != null) {
            transaccionTarjetaService.eliminarTransaccionTarjeta(idTransaccionTarjeta);
            resp.sendRedirect(req.getContextPath() + "/TransaccionTarjeta/");
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
                int idTransaccionTarjeta = Integer.parseInt(pathParts[1]);
                eliminarTransaccionTarjeta(idTransaccionTarjeta, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
}
