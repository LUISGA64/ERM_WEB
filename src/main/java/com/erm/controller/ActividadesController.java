package com.erm.controller;

import com.erm.ejb.ActividadesFacadeLocal;
import com.erm.model.Actividades;
import com.erm.model.TipoActividad;
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
public class ActividadesController implements Serializable{

    @EJB
    private ActividadesFacadeLocal actividadesEJB;
    private List<Actividades> lstactividades;
    private Actividades selactividad;

    @Inject
    private Actividades actividades;

    @Inject
    private TipoActividad tipoactividad;
    
    @PostConstruct
    public void init() {
        lstactividades = actividadesEJB.findAll();
    }

    //Getter & Setter
    public List<Actividades> getLstactividades() {
        return lstactividades;
    }

    public void setLstactividades(List<Actividades> lstactividades) {
        this.lstactividades = lstactividades;
    }

    public Actividades getSelactividad() {
        return selactividad;
    }

    public void setSelactividad(Actividades selactividad) {
        this.selactividad = selactividad;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public TipoActividad getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(TipoActividad tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    //Metodo Registrar
    public void registrar() {
        try {
            actividadesEJB.create(actividades);
            System.out.println("Id: "+actividades.getIdactividad() + "Codigo: "+actividades.getCodActividad()+" Descripcion: "+actividades.getDesActividad()+"Tipo: "+actividades.getIdtipActividad().getDestipActividad());
            lstactividades = actividadesEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividades", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividades", "Registro Fallido."));
            System.out.println("Id: "+actividades.getIdactividad() + "Codigo: "+actividades.getCodActividad()+" Descripcion: "+actividades.getDesActividad()+"Tipo: "+actividades.getIdtipActividad().getDestipActividad());
        }
    }
    
    public void editar(RowEditEvent event){
        try{
            Actividades act1 = (Actividades) event.getObject();
            Actividades act2 = actividadesEJB.find(act1.getIdactividad());
            act2.setCodActividad(act1.getCodActividad());
            act2.setDesActividad(act1.getDesActividad());
            act2.setIdtipActividad(act1.getIdtipActividad());
            actividadesEJB.edit(act2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividades", "Registro Modificado."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividades", "Error de edicion"));
        }
    }
    
    public void eliminar(){
        try{
            actividadesEJB.remove(selactividad);
            selactividad = null;
            lstactividades = actividadesEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Actividades", "Registro Eliminado "));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Actividades", "Registro No Eliminado "));
        }
    }
}
