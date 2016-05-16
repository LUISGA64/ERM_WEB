package com.erm.controller;

import com.erm.ejb.EspecialidadFacadeLocal;
import com.erm.model.Especialidad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class EspecialidadController implements Serializable {

    @EJB
    private EspecialidadFacadeLocal especialidadEJB;
    private List<Especialidad> lstespecialidad;
    private Especialidad selesp;

    @Inject
    private Especialidad especialidad;

    @PostConstruct
    public void init() {
        lstespecialidad = especialidadEJB.findAll();
    }

    // Getter & Setter
    public Especialidad getSelesp() {
        return selesp;
    }

    public void setSelesp(Especialidad selesp) {
        this.selesp = selesp;
    }

    public List<Especialidad> getLstespecialidad() {
        return lstespecialidad;
    }

    public void setLstespecialidad(List<Especialidad> lstespecialidad) {
        this.lstespecialidad = lstespecialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

// metodos
    public void registrar() {
        try {
            especialidadEJB.create(especialidad);
            lstespecialidad = especialidadEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Especialidad", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Especialidad", "Registro Falló."));
        }
    }

    public void editar(RowEditEvent event) {
        try {
            Especialidad esp1 = (Especialidad) event.getObject();
            Especialidad esp2 = especialidadEJB.find(esp1.getIdespecialidad());
            esp2.setCodEspecialidad(esp1.getCodEspecialidad());
            esp2.setDescripcion(esp1.getDescripcion());
            especialidadEJB.edit(esp2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERM - Especialidad", "Registro Modificado."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERM - Especialidad", "Registro no Modificado. " + e));
        }
    }

    public void eliminar() {
        try {
            especialidadEJB.remove(selesp);
            selesp = null;
            lstespecialidad = especialidadEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Especialidad", "Registro Eliminado "));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Especialidad", "Registro No Eliminado " + e));
        }
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
}
