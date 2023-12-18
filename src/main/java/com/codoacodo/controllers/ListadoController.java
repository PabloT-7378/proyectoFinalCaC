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

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    OradorDAO dao = new OradorDAO();

    try {
        List<Orador> listado = dao.listarOradores();
        req.setAttribute("listado", listado);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
    }

    
}
