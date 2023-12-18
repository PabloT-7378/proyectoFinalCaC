package com.codoacodo.connection;

/**
 *
 * @author Pablo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {

    private static final String URL = "jdbc:mysql://localhost:3306/integrador_cac";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC", e);
        }

        return conn;
    }

    public static void main(String[] args) {
        try (Connection conn = AdministradorDeConexiones.getConnection()) {
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}

