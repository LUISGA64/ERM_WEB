package com.erm.controller;

import com.erm.ejb.FormaFarmaceuticaFacadeLocal;
import com.erm.model.FormaFarmaceutica;
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
public class FormaFarmaceuticaController implements Serializable{
    
    @EJB
    private FormaFarmaceuticaFacadeLocal formafarmaceuticaEJB;
    private List<FormaFarmaceutica> lstformaf;
    private FormaFarmaceutica selformaf;
    
    @Inject
    private FormaFarmaceutica formafarmaceutica;
    
    @PostConstruct
    public void init(){
        lstformaf = formafarmaceuticaEJB.findAll();
    }
    
    /* Setter y Getter*/

    public List<FormaFarmaceutica> getLstformaf() {
        return lstformaf;
    }

    public void setLstformaf(List<FormaFarmaceutica> lstformaf) {
        this.lstformaf = lstformaf;
    }

    public FormaFarmaceutica getSelformaf() {
        return selformaf;
    }

    public void setSelformaf(FormaFarmaceutica selformaf) {
        this.selformaf = selformaf;
    }

    public FormaFarmaceutica getFormafarmaceutica() {
        return formafarmaceutica;
    }

    public void setFormafarmaceutica(FormaFarmaceutica formafarmaceutica) {
        this.formafarmaceutica = formafarmaceutica;
    }
    
    public void registrar(){
        try{
            formafarmaceuticaEJB.create(formafarmaceutica);
            lstformaf = formafarmaceuticaEJB.findAll();
            System.out.println("Forma Farmaceutica"+formafarmaceutica.getCodFormaFarma()+" Descripcion: "+formafarmaceutica.getCodFormaFarma());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Forma Farmaceutica", "Registro Exitoso."));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Forma Farmaceutica", "Registro Fallo."+e));
        }
    }
    
    public void editar(RowEditEvent event){
        FormaFarmaceutica frmf1 = (FormaFarmaceutica) event.getObject();
        FormaFarmaceutica frmf2 = formafarmaceuticaEJB.find(frmf1.getIdFormaf());
        frmf2.setCodFormaFarma(frmf1.getCodFormaFarma());
        frmf2.setFormaFarma(frmf1.getFormaFarma());
        formafarmaceuticaEJB.edit(frmf2);
        formafarmaceuticaEJB.findAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Departamento Modificado."));
    }
    
    public void eliminar(){
        try{
            formafarmaceuticaEJB.remove(selformaf);
            selformaf = null;
            lstformaf = formafarmaceuticaEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Forma Farmaceutica", "Registro Eliminado "));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Forma Farmaceutica", "Registro No Eliminado "+e));
        }
    }
}
