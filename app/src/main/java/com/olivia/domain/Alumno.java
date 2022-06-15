package com.olivia.domain;

public class Alumno {
    private String nombre;
    private String correo;
    private String contrasenia;
    private String pais;
    private String codigoPostal;

    public Alumno(){

    }

    public Alumno(String nombre, String correo, String contrasenia, String pais, String codigoPostal){
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
