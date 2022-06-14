package com.olivia.domain;

public class Docente {

    private String nombre;
    private String apelldidoPaterno;
    private String apellidoMaterno;
    private String cedula;
    private String codigoPostal;
    private String contrasenia;

    public Docente(){

    }

    public Docente(String nombre, String apelldidoPaterno, String apellidoMaterno,
                   String cedula, String codigoPostal, String contrasenia) {
        this.nombre = nombre;
        this.apelldidoPaterno = apelldidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cedula = cedula;
        this.codigoPostal = codigoPostal;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldidoPaterno() {
        return apelldidoPaterno;
    }

    public void setApelldidoPaterno(String apelldidoPaterno) {
        this.apelldidoPaterno = apelldidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
