package com.erm.controller;

import com.erm.ejb.MedicoFacadeLocal;
import com.erm.model.Especialidad;
import com.erm.model.Medico;
import com.erm.model.TipoDoc;
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
public class MedicoController implements Serializable {

    @EJB
    private MedicoFacadeLocal medicoEJB;
    private List<Medico> lstmedico;
    private Medico selmed;

    @Inject
    private Medico medico;

    @Inject
    private TipoDoc tipodoc;
    @Inject
    private Especialidad especialidad;

    @PostConstruct
    public void init() {
        lstmedico = medicoEJB.findAll();
    }

    // Getter & Setter
    public Medico getSelmed() {
        return selmed;
    }

    public void setSelmed(Medico selmed) {
        this.selmed = selmed;
    }

    public List<Medico> getLstmedico() {
        return lstmedico;
    }

    public void setLstmedico(List<Medico> lstmedico) {
        this.lstmedico = lstmedico;
    }

    public TipoDoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDoc tipodoc) {
        this.tipodoc = tipodoc;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void registrar() {
        try {
            medicoEJB.create(medico);
            lstmedico = medicoEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Medico", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Medico", "Registro Falló."));
        }
    }

    public void editar(RowEditEvent event){
        try{
        Medico md1 = (Medico)event.getObject();
        Medico md2 = medicoEJB.find(md1.getIdmedico());
        md2.setNombre1(md1.getNombre1());
        md2.setNombre2(md1.getNombre2());
        md2.setApellido1(md1.getApellido1());
        md2.setApellido2(md1.getApellido2());
        md2.setTipoDoc(md1.getTipoDoc());
        md2.setIdeMed(md1.getIdeMed());
        md2.setRegistro(md1.getRegistro());
        md2.setEspecialidad(md1.getEspecialidad());
        medicoEJB.edit(md2);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERM - Médico", "Registro Modificado."));}
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERM - Médico", "Registro no Modificado. " +e));}
        }
    
    public void eliminar() {
        medicoEJB.remove(selmed);
        selmed = null;
        lstmedico = medicoEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM - Medico", "Registro Eliminado"));
        System.out.println("Seleccionado: " + medico.getIdeMed());
    }
}
