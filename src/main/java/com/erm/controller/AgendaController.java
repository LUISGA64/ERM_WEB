package com.erm.controller;

import com.erm.ejb.AgendaFacadeLocal;
import com.erm.model.Agenda;
import com.erm.model.Medico;
import com.erm.model.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ViewScoped
@Named
public class AgendaController implements Serializable {

    @EJB
    private AgendaFacadeLocal agendaEJB;
    private List<Agenda> lstagenda;
    private ArrayList<Agenda> lista=new ArrayList<>();
    private Agenda selagenda;

    @Inject
    private Agenda agenda;

    @Inject
    private Medico medico;

    @Inject
    private Persona persona;

    @PostConstruct
    public void init()  {
        lstagenda = agendaEJB.findAll();
        lista=new ArrayList<>();
        try {
            for (Agenda item : lstagenda) {
                lista.add(item.clonar());
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }

    public Agenda getSelagenda() {
        return selagenda;
    }

    public void setSelagenda(Agenda selagenda) {
        this.selagenda = selagenda;
    }
    
    
    public List<Agenda> getLista() {
        return lista;
    }

    public void setLista(List<Agenda> lista) {
        this.lista = (ArrayList<Agenda>) lista;
    }

    public List<Agenda> getLstagenda() {
        return lstagenda;
    }

    public void setLstagenda(List<Agenda> lstagenda) {
        this.lstagenda = lstagenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    /*
 

    public void registrar() {
        try {
            for (Agenda agend : lista) {
                if (agend.compararfechacita(agenda.getFechaCita())== 0) {
                    agendaEJB.create(agenda);
                    lstagenda = agendaEJB.findAll();
                    System.out.println("Lista: " + lista);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departamento", "Registro Exitoso."));
                    System.out.println("fecha cita: " + agenda.getFechaCita() + " hora cita: " + agenda.getHora() + " Medico: " + agenda.getIdMedico().getNombre1() + " " + agenda.getIdMedico().getNombre2());
                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda", "Error no se registro el erro"));
        }
    }*/

     public void registrar() {
        try {
            agendaEJB.create(agenda);
            lstagenda = agendaEJB.findAll();
            
            System.out.println("Lista: " + lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departamento", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departamento", "Turno Asignado"));
        }
    }
     
     public void peso() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registre peso de paciente"));
    }
}
