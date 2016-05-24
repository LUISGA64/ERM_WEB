package com.erm.controller;

import com.erm.ejb.UnidadMedidaFacadeLocal;
import com.erm.model.UnidadMedida;
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

@ViewScoped
@Named
public class UnidadMedidaController implements Serializable{
    
    @EJB
    private UnidadMedidaFacadeLocal unidadmedidaEJB;
    private List<UnidadMedida> lstundmed;
    private UnidadMedida selundmed;
    
    @Inject
    private UnidadMedida unidadmedida;
    
    @PostConstruct
    public void init(){
        lstundmed = unidadmedidaEJB.findAll();
    }
    
    /*Setter && Getter*/

    public List<UnidadMedida> getLstundmed() {
        return lstundmed;
    }

    public void setLstundmed(List<UnidadMedida> lstundmed) {
        this.lstundmed = lstundmed;
    }

    public UnidadMedida getSelundmed() {
        return selundmed;
    }

    public void setSelundmed(UnidadMedida selundmed) {
        this.selundmed = selundmed;
    }
    
    /*Metodo para Registrar Unidades de Medida utilizadas en administración de medicamentos*/
    public void registrar(){
        try{
            unidadmedidaEJB.create(unidadmedida);
            lstundmed = unidadmedidaEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad Medida", "Registro Exitoso."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unidad Medida", "Registro Falló."));
        }
    }
    
    public void buscar(){
        try{
            
        }catch(Exception e){
            
        }
    }
    
    
    public void editar(RowEditEvent event){
        try{
            UnidadMedida und1 = (UnidadMedida) event.getObject();
            UnidadMedida und2 = unidadmedidaEJB.find(und1.getIdUnd());
            und2.setCodUnd(und1.getCodUnd());
            und2.setDesUnd(und1.getDesUnd());
            unidadmedidaEJB.edit(und2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Unidad Medida", "Registro Editado"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Unidad Medida", "Cambios no Realizado"));
        }
    }
    
    public void eliminar(){
        try{
            unidadmedidaEJB.remove(selundmed);
            System.out.println("Registro Eliminado: "+" Codigo: "+selundmed.getCodUnd()+" Descripcion: "+selundmed.getDesUnd());
            selundmed = null;
            lstundmed = unidadmedidaEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Unidad Medida", "Registro Eliminado"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Unidad Medida", "No se elimina "+e));
        }
    }
}
