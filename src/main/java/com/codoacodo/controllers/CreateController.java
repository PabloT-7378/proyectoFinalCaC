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

@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           try {
                String nombre = req.getParameter("nombre");
                String apellido = req.getParameter("apellido");
                String mail = req.getParameter("mail");
                String tema = req.getParameter("tema");

                OradorDAO dao = new OradorDAO();

                dao.insertarOrador(nombre, apellido, mail, tema);

                resp.sendRedirect(req.getContextPath() + "/api/ListadoController");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
      }
    
}
