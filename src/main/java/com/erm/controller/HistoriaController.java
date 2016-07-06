package com.erm.controller;

import com.erm.ejb.HistoriaFacadeLocal;
import com.erm.ejb.MedicamentosFacadeLocal;
import com.erm.model.Agenda;
import com.erm.model.CausExterna;
import com.erm.model.Cie10;
import com.erm.model.FinalCx;
import com.erm.model.Historia;
import com.erm.model.Medicamentos;
import com.erm.model.Medico;
import com.erm.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@Named
@ViewScoped
public class HistoriaController implements Serializable{

    @EJB
    private HistoriaFacadeLocal historiaEJB;
    private MedicamentosFacadeLocal medicamentosEJB;
    private List<Historia> lsthistoria;
    private Historia selhistoria;
    private boolean repetido;
    private List<Medicamentos> lstmedicamentos;
    private String message;
    private List<Cie10> lstdx;
    
    
    @Inject
    private Historia historia;
    @Inject
    private Persona persona;
    @Inject
    private Medico medico;
    @Inject
    private Agenda agenda;
    @Inject
    private Cie10 cie10;
    @Inject
    private FinalCx finalidadCx;
    @Inject
    private CausExterna causaexterna;
    
    @PostConstruct
    public void init(){
      lsthistoria = historiaEJB.findAll();
    }
    
    /*Metodos Setter && Getter*/

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    
    
    public List<Medicamentos> getLstmedicamentos() {
        return lstmedicamentos;
    }

    public void setLstmedicamentos(List<Medicamentos> lstmedicamentos) {
        this.lstmedicamentos = lstmedicamentos;
    }

    public MedicamentosFacadeLocal getMedicamentosEJB() {
        return medicamentosEJB;
    }

    public void setMedicamentosEJB(MedicamentosFacadeLocal medicamentosEJB) {
        this.medicamentosEJB = medicamentosEJB;
    }
    
    public List<Historia> getLsthistoria() {
        return lsthistoria;
    }

    public void setLsthistoria(List<Historia> lsthistoria) {
        this.lsthistoria = lsthistoria;
    }

    public Historia getSelhistoria() {
        return selhistoria;
    }

    public void setSelhistoria(Historia selhistoria) {
        this.selhistoria = selhistoria;
    }

    public boolean isRepetido() {
        return repetido;
    }

    public void setRepetido(boolean repetido) {
        this.repetido = repetido;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Cie10 getCie10() {
        return cie10;
    }

    public void setCie10(Cie10 cie10) {
        this.cie10 = cie10;
    }

    
    public void registrar(){
        try
        {
            historiaEJB.create(historia);
            lsthistoria = historiaEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Historia", "Registro Exitoso."));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Historia", "Registro Falló."));
        }
    }
    public void onTabClose(TabCloseEvent event){
        FacesMessage msg = new FacesMessage("Panel Cerrado:",event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onTabChange(TabChangeEvent event){
        FacesMessage msg = new FacesMessage("Panel Activo",event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
