package com.erm.controller;

import com.erm.ejb.UndMedidaFacadeLocal;
import com.erm.model.UndMedida;
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
public class UndMedidaController implements Serializable{
    
    @EJB
    private UndMedidaFacadeLocal UndMedidaEJB;
    private List<UndMedida> lstundmedida;
    
    @Inject
    private UndMedida undmedida;
    
    @PostConstruct
    public void init(){
        lstundmedida = UndMedidaEJB.findAll();
    }

    //Getter & Setter

    public UndMedidaFacadeLocal getUndMedidaEJB() {
        return UndMedidaEJB;
    }

    public void setUndMedidaEJB(UndMedidaFacadeLocal UndMedidaEJB) {
        this.UndMedidaEJB = UndMedidaEJB;
    }

    public List<UndMedida> getLstundmedida() {
        return lstundmedida;
    }

    public void setLstundmedida(List<UndMedida> lstundmedida) {
        this.lstundmedida = lstundmedida;
    }

    public UndMedida getUndmedida() {
        return undmedida;
    }

    public void setUndmedida(UndMedida undmedida) {
        this.undmedida = undmedida;
    }
    
    
    public void registrar(){
        try{
            UndMedidaEJB.create(undmedida);
            lstundmedida = UndMedidaEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registro Falló."));
        }
    }
    
    
}
