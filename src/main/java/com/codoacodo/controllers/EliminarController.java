package com.codoacodo.controllers;

import com.codoacodo.dao.OradorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo
 */

@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");

            OradorDAO dao = new OradorDAO();
            dao.eliminarOrador(Integer.parseInt(id));

            resp.sendRedirect(req.getContextPath() + "/api/ListadoController");
        } catch (NumberFormatException |SQLException e) {
            e.printStackTrace(System.out);
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        } 
        
    }
    
}
