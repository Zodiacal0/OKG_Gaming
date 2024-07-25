package com.okg.okg_project.resources.servlets;

import com.okg.okg_project.resources.model.Paypal;
import com.okg.okg_project.resources.services.PaypalService;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PaypalServlet", urlPatterns = { "/PaypalServlet" })
@MultipartConfig
public class PaypalServlet extends HttpServlet {

    private PaypalService paypalService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.paypalService = new PaypalService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Paypal> paypal = paypalService.listarPaypal();
        paypal.forEach(u -> System.out.println(u));
        req.setAttribute("paypal", paypal);
        req.getRequestDispatcher("/pages/paypal.jsp").forward(req, resp);
    }

    private void crearPaypal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPaypal = 0;
        String email = req.getParameter("email");
        int idMetodoDePago = Integer.parseInt(req.getParameter("idMetodoDePago"));

        Paypal paypal = new Paypal(idPaypal, email, idMetodoDePago);
        paypalService.crearPaypal(paypal);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            crearPaypal(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        }
    }

    private void editarPaypal(int idPaypal, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Paypal paypal = paypalService.buscarPaypal(idPaypal);
        if (paypal != null) {
            String email = req.getParameter("email");
            String idMetodoDePago = req.getParameter("idMetodoDePago");

            paypal.setIdPaypal(idPaypal);
            paypal.setEmail(email);
            paypal.setIdMetodoDePago(idPaypal);

            paypalService.editarPaypal(paypal);

            resp.sendRedirect(req.getContextPath() + "/Paypal/");
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
                int idPaypal = Integer.parseInt(pathParts[1]);
                editarPaypal(idPaypal,req,resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void eliminarPaypal(int idPaypal, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Paypal paypal  = paypalService.buscarPaypal(idPaypal);
        if (paypal != null) {
            paypalService.eliminarPaypal(idPaypal);
            resp.sendRedirect(req.getContextPath() + "/Paypal/");
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
                eliminarPaypal(idDesarrolladora, req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
