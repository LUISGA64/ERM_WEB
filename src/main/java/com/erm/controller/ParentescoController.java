
package com.erm.controller;

import com.erm.ejb.ParentescoFacadeLocal;
import com.erm.model.Parentesco;
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
public class ParentescoController implements Serializable {
    
    @EJB
    private ParentescoFacadeLocal parentescoEJB;
    private List<Parentesco> lstparentesco;
    
    @Inject
    private Parentesco parentesco;
    
    @PostConstruct
    public void init(){
        lstparentesco = parentescoEJB.findAll();
    }
    
    //Getter & Setter

    public List<Parentesco> getLstparentesco() {
        return lstparentesco;
    }

    public void setLstparentesco(List<Parentesco> lstparentesco) {
        this.lstparentesco = lstparentesco;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
    
    public void registrar(){
        try{
            parentescoEJB.create(parentesco);
            lstparentesco = parentescoEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registro Falló."));
        }
    }
}
