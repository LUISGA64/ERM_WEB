package com.erm.controller;
import com.erm.ejb.TipoActividadFacadeLocal;
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

@Named
@ViewScoped
public class TipoactividadController implements Serializable {

    @EJB
    private TipoActividadFacadeLocal tipoactividadEJB;
    private List<TipoActividad> lsttipoactividad;
    private TipoActividad seltipactividad;

    @Inject
    private TipoActividad tipoactividad;

    @PostConstruct
    public void init() {
       lsttipoactividad = tipoactividadEJB.findAll();
    }

    /*Metodos Getter && Setter*/

    public List<TipoActividad> getLsttipoactividad() {
        return lsttipoactividad;
    }

    public void setLsttipoactividad(List<TipoActividad> lsttipoactividad) {
        this.lsttipoactividad = lsttipoactividad;
    }

    public TipoActividad getSeltipactividad() {
        return seltipactividad;
    }

    public void setSeltipactividad(TipoActividad seltipactividad) {
        this.seltipactividad = seltipactividad;
    }

    public TipoActividad getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(TipoActividad tipoactividad) {
        this.tipoactividad = tipoactividad;
    }
    

    public void registrar() {
        try 
        {
            tipoactividadEJB.create(tipoactividad);
            lsttipoactividad = tipoactividadEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo Actividad", "Registro Exitoso"));
        } catch (Exception e) {

        }
    }
}
