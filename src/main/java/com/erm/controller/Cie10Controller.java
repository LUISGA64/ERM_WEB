package com.erm.controller;

import com.erm.ejb.Cie10FacadeLocal;
import com.erm.model.Cie10;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class Cie10Controller implements Serializable{

    @EJB
    private Cie10FacadeLocal cie10EJB;
    private List<Cie10> lstcie10;
    private Cie10 selcie10;
    

    @Inject
    private Cie10 cie10;

    @PostConstruct
    public void init() {
        lstcie10 = cie10EJB.findAll();
    }

    //Metodos
    public List<Cie10> getLstcie10() {
        return lstcie10;
    }

    public void setLstcie10(List<Cie10> lstcie10) {
        this.lstcie10 = lstcie10;
    }

    public Cie10 getCie10() {
        return cie10;
    }

    public void setCie10(Cie10 cie10) {
        this.cie10 = cie10;
    }

    public Cie10 getSelcie10() {
        return selcie10;
    }

    public void setSelcie10(Cie10 selcie10) {
        this.selcie10 = selcie10;
    }

    public void registrar(){
        try {
            cie10EJB.create(cie10);
            lstcie10 = cie10EJB.findAll();
            this.refresh();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Diagnóstico", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Diagnóstico", "Registro Falló."));
        }
    }
    
    public void leer(RowEditEvent event){
        Cie10 cie1 =(Cie10) event.getObject();
        Cie10 cie2 = cie10EJB.find(cie1.getCodCie10());
        cie2.setCodCie10(cie1.getCodCie10());
        cie2.setDesCie10(cie1.getDesCie10());
        cie2.setAlerta(cie1.getAlerta());
        cie10EJB.edit(cie2);
        System.out.println("Seleccion: " + cie2.getCodCie10() + " Descripcion: " + cie2.getDesCie10()+" Alerta: "+cie2.getAlerta());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Diagnóstico", "Registro Modificado."));
    }
    
    public void refresh() {
    FacesContext context = FacesContext.getCurrentInstance();
    Application application = context.getApplication();
    ViewHandler viewHandler = application.getViewHandler();
    UIViewRoot viewRoot = viewHandler.createView(context, context
     .getViewRoot().getViewId());
    context.setViewRoot(viewRoot);
    context.renderResponse(); 
 }
    
    public void eliminar(){
        try{
            cie10EJB.remove(selcie10);
            System.out.println("com.erm.controller.Cie10Controller.eliminar()");
            selcie10 = null;
            lstcie10 = cie10EJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Diagnóstico", "Registro Eliminado "));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERM- Diagnóstico", "Registro No Eliminado "));
        }
    }
}
