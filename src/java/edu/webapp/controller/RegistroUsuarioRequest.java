/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webapp.controller;

import edu.webapp.entity.Usuario;
import edu.webapp.facade.UsuarioFacadeLocal;
import edu.webapp.utilities.Email;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author HP
 */
@ManagedBean
@RequestScoped
public class RegistroUsuarioRequest implements Serializable{
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    
    private Usuario usuReg = new Usuario();
    private String correoRecuperar = "";
    
    public RegistroUsuarioRequest() {
    }

    public void crearUsuario(){
        String mensajeSW = "";
        
        try {
            usuReg.setFechaRegistro(new Date());
            usuarioFacadeLocal.create(usuReg);
            mensajeSW = "swal('Usuario registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSW = "swal('El usuario' , ' Ya se encuentra registrado ', 'error')";
        }
        usuReg = new Usuario();
        PrimeFaces.current().executeScript(mensajeSW);
    }
    
    public void recuperarClave() {
        Usuario usuRecuperar = new Usuario();
        String mensajeSW = "";
        
        try {
            usuRecuperar = usuarioFacadeLocal.recuperarClave(correoRecuperar);
            if(usuRecuperar.getNombres() == null){
                mensajeSW = "swal('El correo' , ' No se encuentra registrado ', 'error')";
            } else{
                Email.sendClaves(usuRecuperar.getCorreo(),
                                    usuRecuperar.getNombres() + " " + usuRecuperar.getApellidos(), 
                                    usuRecuperar.getCorreo(), 
                                    usuRecuperar.getClave());
                mensajeSW = "swal('Clave enviada' , ' a su correo electronico ', 'success')";
            }
        } catch (Exception e) {
            mensajeSW = "swal('El correo' , ' No se encuentra registrado ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSW);
    }
    
    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public String getCorreoRecuperar() {
        return correoRecuperar;
    }

    public void setCorreoRecuperar(String correoRecuperar) {
        this.correoRecuperar = correoRecuperar;
    }
    
}
