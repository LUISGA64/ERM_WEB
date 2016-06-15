package com.erm.controller;

import com.erm.ejb.AgendaFacadeLocal;
import com.erm.model.Agenda;
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

@ViewScoped
@Named
public class AgendaController implements Serializable {

    @EJB
    private AgendaFacadeLocal agendaEJB;
    private List<Agenda> lstagenda;
    private List<Agenda> lista;
    private List<Agenda> lista1;

    @Inject
    private Agenda agenda;

    @Inject
    private Medico medico;

    @Inject
    private Persona persona;

    @PostConstruct
    public void init() {
        lstagenda = agendaEJB.findAll();

    }

    public List<Agenda> getLista() {
        return lista;
    }

    public void setLista(List<Agenda> lista) {
        this.lista = lista;
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

    public void registrar() {
        try {
            for (Agenda a : lista) {
                if(!lista.isEmpty()){
                    if (a.getHora() != agenda.getHora()) {
                    agendaEJB.create(agenda);
                    lstagenda = agendaEJB.findAll();
                    System.out.println("Lista: " + lista);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departamento", "Registro Exitoso."));
                    System.out.println("fecha cita: " + agenda.getFechaCita() + " hora cita: " + agenda.getHora() + " Medico: " + agenda.getIdMedico().getNombre1() + " " + agenda.getIdMedico().getNombre2());
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Departamento", "Turno Asignado"));
                }
                }  
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda", "Error"));
        }

    }
}
