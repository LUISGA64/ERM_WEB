package com.erm.controller;

import com.erm.ejb.NivelEducativoFacadeLocal;
import com.erm.model.NivelEducativo;
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
public class NivelEducativoController implements Serializable{
    
    @EJB
    private NivelEducativoFacadeLocal niveleducativoEJB;
    private List<NivelEducativo> lstniveleducativo;
    
    @Inject
    private NivelEducativo niveleducativo;
    
    @PostConstruct
    public void init(){
        lstniveleducativo =niveleducativoEJB.findAll();
    }

    public List<NivelEducativo> getLstniveleducativo() {
        return lstniveleducativo;
    }

    public void setLstniveleducativo(List<NivelEducativo> lstniveleducativo) {
        this.lstniveleducativo = lstniveleducativo;
    }

    public NivelEducativo getNiveleducativo() {
        return niveleducativo;
    }

    public void setNiveleducativo(NivelEducativo niveleducativo) {
        this.niveleducativo = niveleducativo;
    }
    
    
    public void registrar(){
        try{
            niveleducativoEJB.create(niveleducativo);
            lstniveleducativo = niveleducativoEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registro Falló."));
        }
    }
    
}
