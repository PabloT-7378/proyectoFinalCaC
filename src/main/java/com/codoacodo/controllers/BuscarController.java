package com.codoacodo.controllers;

import com.codoacodo.dao.OradorDAO;
import com.codoacodo.dto.Orador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo
 */

@WebServlet("/api/BuscarController")
public class BuscarController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
        String clave = req.getParameter("clave");

        OradorDAO dao = new OradorDAO();

        List<Orador> list = dao.buscar(clave);

        req.setAttribute("listado", list);

        getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
    } catch (SQLException e) {
        e.printStackTrace(System.out);
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la búsqueda");
    }
}

    
}
