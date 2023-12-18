package com.codoacodo.controllers;

import com.codoacodo.connection.AdministradorDeConexiones;
import com.codoacodo.dto.Orador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo
 */

@WebServlet("/api/ConsultarController")
public class ConsultarController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");

    String sql = "SELECT * FROM ORADOR WHERE id_orador = ?";
    Connection conn = null;

    try {
        conn = AdministradorDeConexiones.getConnection();

        if (conn != null) {
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, Integer.parseInt(id));

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        int idOrador = rs.getInt(1);
                        String nombre = rs.getString(2);
                        String apellido = rs.getString(3);
                        String mail = rs.getString(4);
                        String tema = rs.getString(5);
                        Timestamp fechaAlta = rs.getTimestamp(6);

                        Orador oraFromDb = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);

                        req.setAttribute("orador", oraFromDb);
                    }
                }
            }

            getServletContext().getRequestDispatcher("/detalle.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

}

