package com.erm.controller;

import com.erm.ejb.UsuarioFacadeLocal;
import com.erm.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class IndexController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    //Getter && Setter
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        Usuario us;
        String redirect = null;
        boolean logeado = false;
        FacesMessage msg = null;
        try {
            us = usuarioEJB.iniciarSesion(usuario);
            if (us != null) {
                if (us.getIdrol().getIdRol() == 1) {
                    RequestContext context = RequestContext.getCurrentInstance();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                    redirect = "/protegido/menu?faces-redirect=true";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "" + us.getIdrol().getRol()));
                    System.out.println("\n" + "Usuario: " + us.getUsuario() + "\n" + "Rol: " + us.getIdrol().getRol() + "\n" + "Estado: " + us.getEstado());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "" + us.getIdrol().getRol()));
                }
                if (us.getIdrol().getIdRol() == 2) {
                    RequestContext context = RequestContext.getCurrentInstance();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                    redirect = "/asistencial/consultaExterna?faces-redirect=true";
                    System.out.println("\n" + "Usuario: " + us.getUsuario() + "\n" + "Rol: " + us.getIdrol().getRol() + "\n" + "Estado: " + us.getEstado());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "" + us.getIdrol().getRol()));
                }
                logeado = true;

            } else {
                logeado = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Incorrecto "));
            }
        } catch (Exception e) {
            // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Incorrecto " + e));
        }
        return redirect;
    }

    public void resetInput() {

    }

    /*Mensajes*/
    public void errorUsuario() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registre Usuario"));
    }

    public void errorPass() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registre Password"));
    }

    public void bienvenido() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido ", "" + usuario.getIdrol().getRol()));
    }

}
