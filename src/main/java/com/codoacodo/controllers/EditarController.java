package com.codoacodo.controllers;

import com.codoacodo.dao.OradorDAO;
import com.codoacodo.dto.Orador;
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

@WebServlet("/EditarController")
public class EditarController extends HttpServlet {

   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String idOrador = req.getParameter("id");

    try {
        OradorDAO dao = new OradorDAO();
        
        Orador oraFromDb = dao.obtenerPorId(Integer.parseInt(idOrador));

        req.setAttribute("orador", oraFromDb);

        getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);

    } catch (NumberFormatException e) {
        System.out.println("Excepción al convertir ID a entero: " + e.getMessage());
        resp.sendRedirect(req.getContextPath() + "/error.jsp");
    } catch (SQLException e) {
        System.out.println("Excepción SQL al obtener orador: " + e.getMessage());
        resp.sendRedirect(req.getContextPath() + "/error.jsp");
    }
}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String mail = req.getParameter("mail");
        String tema = req.getParameter("tema");
        String id = req.getParameter("id");
        OradorDAO dao = new OradorDAO();

        try {
            dao.actualizarOrador(Integer.valueOf(id), nombre, apellido, mail, tema);

            resp.sendRedirect(req.getContextPath() + "/api/ListadoController");

        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace(System.out);
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }

}

