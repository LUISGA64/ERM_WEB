package com.erm.controller;

import com.erm.ejb.OcupacionFacadeLocal;
import com.erm.model.Ocupacion;
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
public class OcupacionController implements Serializable{
    
    @EJB
    private OcupacionFacadeLocal ocupacionEJB;
    private List<Ocupacion> lstocupacion;
    private Ocupacion ocsel;
    
    @Inject
    private Ocupacion ocupacion;
    
    @PostConstruct
    public void init(){
        lstocupacion = ocupacionEJB.findAll();
    }
    
    // Constructores 

    public List<Ocupacion> getLstocupacion() {
        return lstocupacion;
    }

    public void setLstocupacion(List<Ocupacion> lstocupacion) {
        this.lstocupacion = lstocupacion;
    }

    public Ocupacion getOcsel() {
        return ocsel;
    }

    public void setOcsel(Ocupacion ocsel) {
        this.ocsel = ocsel;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
    public void registrar(){
        try{
            ocupacionEJB.create(ocupacion);
            lstocupacion = ocupacionEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocupación", "Registro Exitoso.  "));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocupación", "Registro Falló.  "));
        }
    }
    
    public void editar(RowEditEvent event){
        Ocupacion oc1 = (Ocupacion) event.getObject();
        Ocupacion oc2 = ocupacionEJB.find(oc1.getIdocupacion());
        oc2.setCodigoOcp(oc1.getCodigoOcp());
        oc2.setDescripcionOcp(oc1.getDescripcionOcp());
        ocupacionEJB.edit(oc2);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ocupación", "Registro Modificado."));
    }

    public void eliminar(){
        try
        {
        ocupacionEJB.remove(ocsel);
        ocsel = null;
        lstocupacion = ocupacionEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM - Ocupación", "Registro Eliminado"));
        System.out.println("Seleccionado: "+ocsel);
        }
        catch(Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM - Ocupación", "Registro No Eliminado "+e));
        }
    }
}
