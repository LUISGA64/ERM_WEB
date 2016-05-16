package com.erm.controller;

import com.erm.ejb.DepartamentoFacadeLocal;
import com.erm.model.Departamento;
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
public class DepartamentoController implements Serializable{
    
    @EJB
    private DepartamentoFacadeLocal departamentoEJB;
    private List<Departamento> lstdepartamento;
    private Departamento depsel;
    
    @Inject
    private Departamento departamento;
    
    @PostConstruct
    public void init(){
        lstdepartamento = departamentoEJB.findAll();
    }
    
    //Getter & Setter

    public Departamento getDepsel() {
        return depsel;
    }

    public void setDepsel(Departamento depsel) {
        this.depsel = depsel;
    }
    
    public List<Departamento> getLstdepartamento() {
        return lstdepartamento;
    }

    public void setLstdepartamento(List<Departamento> lstdepartamento) {
        this.lstdepartamento = lstdepartamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public void registrar(){
        try{
            departamentoEJB.create(departamento);
            lstdepartamento = departamentoEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departamento", "Registro Exitoso."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Departamento", "Registro Falló."));
        }
    }
    
    public void leer(RowEditEvent event){
        Departamento dp1 = (Departamento)event.getObject();
        Departamento dp2 = departamentoEJB.find(dp1.getIddepartamento());
        dp2.setCodigoDpto(dp1.getCodigoDpto());
        dp2.setDesDpto(dp1.getDesDpto());
        departamentoEJB.edit(dp2);
        System.out.println("Seleccionado");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Departamento Modificado."));
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
    
    public void eliminar(){
        try{
            departamentoEJB.remove(depsel);
        depsel = null;
        lstdepartamento = departamentoEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Departamento", "Registro Eliminado "));
        System.out.println("Seleccionado: "+departamento.getIddepartamento());}
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Departamento", "Registro No Eliminado "+e));
        }
    }
}
