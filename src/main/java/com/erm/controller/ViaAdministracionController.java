package com.erm.controller;

import com.erm.ejb.ViaAdministracionFacadeLocal;
import com.erm.model.ViaAdministracion;
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

@Named
@ViewScoped
public class ViaAdministracionController implements Serializable {

    @EJB

    private ViaAdministracionFacadeLocal viadmonEJB;
    private ViaAdministracionFacadeLocal viaadministracionEJB;
    private List<ViaAdministracion> lstvadmon;
    private ViaAdministracion selvadmon;

    @Inject
    private ViaAdministracion viaadministracion;

    @PostConstruct
    public void init() {
        lstvadmon = viadmonEJB.findAll();
    }

    /*Getter && Setter*/
 
    public List<ViaAdministracion> getLstvadmon() {
        return lstvadmon;
    }

    public void setLstvadmon(List<ViaAdministracion> lstvadmon) {
        this.lstvadmon = lstvadmon;
    }

    public ViaAdministracion getSelvadmon() {
        return selvadmon;
    }

    public void setSelvadmon(ViaAdministracion selvadmon) {
        this.selvadmon = selvadmon;
    }

    public ViaAdministracion getViaadministracion() {
        return viaadministracion;
    }

    public void setViaadministracion(ViaAdministracion viaadministracion) {
        this.viaadministracion = viaadministracion;
    }

  /* -  Metodos para registra una nueva via de administracion -*/  
    
    public void registrar() {
        try {
            viaadministracionEJB.create(viaadministracion);
            lstvadmon = viaadministracionEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vía Administración", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vía Administración", "Registro Falló."+ e));
        }
    }

    /* -  Metodos para editar un registro de la tabla via de administracion -*/
    
    public void editar(RowEditEvent event) {
        ViaAdministracion vam1 = (ViaAdministracion) event.getObject();
        ViaAdministracion vam2 = viaadministracionEJB.find(vam1.getIdVia());
        vam2.setCodVia(vam1.getCodVia());
        vam2.setDescripcioVia(vam1.getDescripcioVia());
        viaadministracionEJB.edit(vam2);
        lstvadmon = viaadministracionEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vía Administración", "Registro Modificado."));
    }

    /* -  Metodos para eliminar un registro de la tabla via de administracion -*/
    
    public void eliminar() {
        try {
            viaadministracionEJB.remove(selvadmon);
            System.out.println("Eliminado: " + selvadmon.getCodVia() + " Descripcion: " + selvadmon.getDescripcioVia());
            selvadmon = null;
            lstvadmon=viaadministracionEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Vía Administración", "Registro Eliminado "));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Vía Administración", "Registro No Eliminado " + e));
        }
    }
}
