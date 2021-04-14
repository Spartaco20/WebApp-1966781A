/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webapp.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author HP
 */
@ManagedBean
@RequestScoped
public class TestRequest {

    private String nombreUsuario = "";
    private String clave = "";
    /**
     * Creates a new instance of TestRequest
     */
    public TestRequest() {
    }

    public void datosFormulario(){
        System.out.println("Su nombre es: " + this.nombreUsuario + " Su clave es: " + this.clave);
        this.nombreUsuario = "";
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
