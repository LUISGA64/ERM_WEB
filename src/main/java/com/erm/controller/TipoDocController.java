package com.erm.controller;

import com.erm.ejb.TipoDocFacadeLocal;
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

@Named
@ViewScoped
public class TipoDocController implements Serializable{
    
    @EJB
    private TipoDocFacadeLocal tipodocEJB;
    private List<TipoDoc> lsttipodoc;
    
    @Inject
    private TipoDoc tipodoc;
    
    @PostConstruct
    public void init(){
        lsttipodoc = tipodocEJB.findAll();
    }
    
    //Setter & Getter

    public List<TipoDoc> getLsttipodoc() {
        return lsttipodoc;
    }

    public void setLsttipodoc(List<TipoDoc> lsttipodoc) {
        this.lsttipodoc = lsttipodoc;
    }

    public TipoDoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDoc tipodoc) {
        this.tipodoc = tipodoc;
    }
    
    
    public void registrar(){
        try{
            tipodocEJB.create(tipodoc);
            lsttipodoc = tipodocEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tipo Documento REgistrado."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registro Falló."));
        }
    }
    
    
}
