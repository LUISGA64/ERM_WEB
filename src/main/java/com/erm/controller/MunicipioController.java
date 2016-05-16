
package com.erm.controller;

import com.erm.ejb.MunicipioFacadeLocal;
import com.erm.model.Departamento;
import com.erm.model.Municipio;
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
public class MunicipioController implements Serializable{
    
    @EJB
    private MunicipioFacadeLocal municipioEJB;
    private List<Municipio> lstmunicipio;
    private Municipio selmun;
    
    
    @Inject
    private Municipio municipio;
    @Inject
    private Departamento departamento;
    
    @PostConstruct
    public void init(){
        lstmunicipio = municipioEJB.findAll();
    }
    //Getter && Setter

    public List<Municipio> getLstmunicipio() {
        return lstmunicipio;
    }

    public void setLstmunicipio(List<Municipio> lstmunicipio) {
        this.lstmunicipio = lstmunicipio;
    }

    public Municipio getSelmun() {
        return selmun;
    }

    public void setSelmun(Municipio selmun) {
        this.selmun = selmun;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
 
    public void registrar(){
         try {
            municipioEJB.create(municipio);
            lstmunicipio = municipioEJB.findAll();
             System.out.println("Municipio: "+"Codigo: "+municipio.getCodigoMpio()+" Descripcio: "+municipio.getDesMpio()+" Departamento: "+municipio.getIddepartamento());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Municipio", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Municipio", "Registro Falló."));
        }
    }
    
    public void editar(RowEditEvent event){
        Municipio mun1 = (Municipio) event.getObject();
        Municipio mun2 = municipioEJB.find(mun1.getIdMunicipio());
        mun2.setCodigoMpio(mun1.getCodigoMpio());
        mun2.setDesMpio(mun1.getDesMpio());
        mun2.setIddepartamento(mun1.getIddepartamento());
        municipioEJB.edit(mun2);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERM - Municipio", "Registro Modificado."));
    }
    
    public void eliminar(){
        try
        {
           municipioEJB.remove(selmun);
           selmun = null;
           lstmunicipio = municipioEJB.findAll();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Municipio", "Registro Eliminado "));
        }
        catch(Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERM- Municipio", "Registro No Eliminado "+e));
        }
    }
}
