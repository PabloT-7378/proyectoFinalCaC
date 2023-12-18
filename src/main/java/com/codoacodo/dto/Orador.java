package com.codoacodo.dto;

import java.sql.Timestamp;

/**
 *
 * @author Pablo
 */
public class Orador {
    
    private int idOrador; 
    private String nombre;
    private String apellido; 
    private String mail;
    private String tema;
    private Timestamp fechaAlta;
    
    public Orador(int idOrador, String nombre, String apellido, String mail, String tema, Timestamp fechaAlta) {
            this.idOrador = idOrador;
            this.nombre = nombre;
            this.apellido = apellido;
            this.mail = mail;
            this.tema = tema;
            this.fechaAlta = fechaAlta;
    }
    
    public Orador(int idOrador, String nombre, String apellido, String mail, String tema) {
            this.idOrador = idOrador;
            this.nombre = nombre;
            this.apellido = apellido;
            this.mail = mail;
            this.tema = tema;
        }
    
    //Constructor
    
    public Orador(){}

    public int getIdOrador() {
        return idOrador;
    }

    public void setIdOrador(int idOrador) {
        this.idOrador = idOrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    
    
    @Override
    public String toString() {
        return super.toString() + "Orador{" + "tema=" + tema + " - Fecha de Alta=" + fechaAlta +'}';
    }
    
    

}
