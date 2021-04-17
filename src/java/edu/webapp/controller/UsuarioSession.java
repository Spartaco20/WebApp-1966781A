/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webapp.controller;

import edu.webapp.entity.Usuario;
import edu.webapp.facade.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.jboss.weld.bean.builtin.ee.HttpSessionBean;
import org.primefaces.PrimeFaces;

/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class UsuarioSession implements Serializable {
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    
    private String correoIn = "";
    private String claveIn = "";
    
    private Usuario usuLogin = new Usuario();
    
    public UsuarioSession() {
    }

    public void inicioSesion() {
        String mensajeSW = "";
        try {
            usuLogin = usuarioFacadeLocal.loginUsuario(correoIn, claveIn);
            if(usuLogin.getId() == null){
                mensajeSW = "swal('El usuario' , ' No se encuentra registrado ', 'error')";
            } else {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("MiPerfil/index.xhtml");
            }
        } catch (Exception e) {
            mensajeSW = "swal('El usuario' , ' No se encuentra registrado ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSW);
    }
    
    public void actualizarMisDatos() {
        String mensajeSW = "";
        try {
            usuarioFacadeLocal.edit(usuLogin);
            mensajeSW = "swal('Datos Actualizados' , ' Exitosamente ', 'success')";
        } catch (Exception e) {
            mensajeSW = "swal('No se puede' , ' Actualizar mis datos ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSW);
    }
    
    public void cerrarSesion(){
        usuLogin = null;
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
            ((HttpSession) ext.getSession(false)).invalidate();
            fc.getExternalContext().redirect("../index.xhtml");
        } catch (Exception e) {
            System.out.println("Error cerrando sesion UsuarioSession:cerrarSesion " + e.getMessage());
        }
    }
    
    public String getCorreoIn() {
        return correoIn;
    }

    public void setCorreoIn(String correoIn) {
        this.correoIn = correoIn;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }
    
}
