package com.erm.controller;

import com.erm.ejb.UsuarioFacadeLocal;
import com.erm.model.Rol;
import com.erm.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private List<Usuario> lstusuario;
    private Usuario usuariosel;

    @Inject
    private Usuario usuario;
    
    @Inject
    private Rol rol;

    @PostConstruct
    public void init() {
        lstusuario = usuarioEJB.findAll();
    }

    //Getter && Setter
    public List<Usuario> getLstusuario() {
        return lstusuario;
    }

    public void setLstusuario(List<Usuario> lstusuario) {
        this.lstusuario = lstusuario;
    }

    public Usuario getUsuariosel() {
        return usuariosel;
    }

    public void setUsuariosel(Usuario usuariosel) {
        this.usuariosel = usuariosel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    public void registrar() {
        try {
            usuarioEJB.create(usuario);
            lstusuario = usuarioEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario", "Registro Falló."));
        }
    }

    public void editar(RowEditEvent event) {
        try {
            Usuario us1 = (Usuario) event.getObject();
            Usuario us2 = usuarioEJB.find(us1.getIdusuario());
            us2.setNombre1(us1.getNombre1());
            us2.setNombre2(us1.getApellido1());
            us2.setApellido1(us1.getApellido1());
            us2.setApellido2(us1.getApellido2());
            us2.setTipodocUsuario(us1.getTipodocUsuario());
            us2.setIdentificacion(us1.getIdentificacion());
            us2.setUsuario(us1.getUsuario());
            us2.setClave(us1.getClave());
            us2.setEstado(us1.getEstado());
            usuarioEJB.edit(us2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERM - Usuario", "Registro Modificado."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERM - Usuario", "Registro no Modificado. " + e));
        }
    }
    
    public void eliminar(){
        usuarioEJB.remove(usuariosel);
        usuariosel = null;
        lstusuario = usuarioEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM - Usuario", "Registro Eliminado"));
        System.out.println("Seleccionado: "+usuario.getIdusuario());
    }
    
    public void buscar(SelectEvent event){
        Usuario usuario = (Usuario) event.getObject();
        
    }
}
