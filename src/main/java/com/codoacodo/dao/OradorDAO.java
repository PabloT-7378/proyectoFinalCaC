package com.codoacodo.dao;

import com.codoacodo.connection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codoacodo.dto.Orador;
import java.sql.PreparedStatement;
import java.sql.Timestamp;


public class OradorDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM ORADOR";
    private static final String SQL_INSERT = "INSERT INTO ORADOR (nombre, apellido, mail, tema, fecha_alta) VALUES (?, ?, ?, ?, CURRENT_DATE)";
    private static final String SQL_UPDATE = "UPDATE ORADOR SET nombre=?, apellido=?, mail=?, tema=? WHERE id_orador=?";
    private static final String SQL_DELETE = "DELETE FROM ORADOR WHERE id_orador=?";
    private static final String SQL_OBTENER_ID = "SELECT * FROM ORADOR WHERE id_orador=?";
    
    public List<Orador> listarOradores() throws SQLException {
    String sql = SQL_SELECT;
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    List<Orador> list = new ArrayList<>();

    try {
        conn = AdministradorDeConexiones.getConnection();
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            int idOrador = rs.getInt(1);
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            String mail = rs.getString(4);
            String tema = rs.getString(5);
            Timestamp fechaAlta = rs.getTimestamp(6);

            Orador oraFromDb = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
            list.add(oraFromDb);
        }
    } catch (SQLException e) {
        throw e;
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    return list;
}


    
    public void insertarOrador(String nombre, String apellido, String mail, String tema) throws SQLException {
    String sql = SQL_INSERT;
    try (Connection conn = AdministradorDeConexiones.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, mail);
        ps.setString(4, tema);

        ps.executeUpdate();
        
    } catch (SQLException e) {
        throw e;
    }
}

    
    public int actualizarOrador(int idx, String nombre, String apellido, String mail, String tema) throws SQLException {
    Connection conn = AdministradorDeConexiones.getConnection();
    PreparedStatement stmt = null;
    int registros = 0;

    try {
        conn = AdministradorDeConexiones.getConnection();
        stmt = conn.prepareStatement(SQL_UPDATE);
        
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, mail);
        stmt.setString(4, tema);
        stmt.setLong(5, idx);

        registros = stmt.executeUpdate();
    } catch (SQLException  | NullPointerException e) {
        e.printStackTrace(System.out);
    } finally {
        try {
                stmt.close();
                conn.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace(System.out);
        }
    }
    return registros;
}


    
    public List<Orador> buscar(String clave) throws SQLException {
    String sql = SQL_SELECT + " WHERE nombre LIKE ?";
    List<Orador> list = new ArrayList<>();

    try (Connection conn = AdministradorDeConexiones.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "%" + clave + "%");

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int idOrador = rs.getInt("id_orador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String tema = rs.getString("tema");
                Timestamp fechaAlta = rs.getTimestamp("fecha_alta");

                Orador oraFromDb = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
                list.add(oraFromDb);
            }
        }
    } catch (SQLException e) {
        throw e;
    }

    return list;
}


    
    public int eliminarOrador(int id) throws SQLException {
    String sql = SQL_DELETE;
    Connection conn = null;
    PreparedStatement stmt = null;
    int registros = 0;

    try {
            conn = AdministradorDeConexiones.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public Orador obtenerPorId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Orador oradFromDb = null;

        //Statement
        try {
                conn = AdministradorDeConexiones.getConnection();
                stmt = conn.prepareStatement(SQL_OBTENER_ID);
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                //VIENE UN SOLO REGISTRO!!!

                if(rs.next()) {//si existe, hay uno solo
                        // rs > sacando los datos
                        int idOrador = rs.getInt(1);
                        String nombre = rs.getString(2);
                        String apellido = rs.getString(3);
                        String mail = rs.getString(4);
                        String tema = rs.getString(5);
                        Timestamp fechaAlta = rs.getTimestamp(6);

                        //campos crear un objeto????
                        oradFromDb = new Orador(idOrador,nombre,apellido,mail,tema,fechaAlta);
                }			
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		return oradFromDb;
	}

    
}
