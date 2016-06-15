package com.erm.controller;

import com.erm.ejb.PersonaFacadeLocal;
import com.erm.model.Municipio;
import com.erm.model.NivelEducativo;
import com.erm.model.Ocupacion;
import com.erm.model.Parentesco;
import com.erm.model.Persona;
import com.erm.model.TipoDoc;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@Named
public class PersonaController implements Serializable {

    @EJB
    private PersonaFacadeLocal personaEJB;
    private List<Persona> lstpersona;
    private Persona selpersona;
    private List<Persona> listpersona;
    private Persona personaseleccionada;
    

    @Inject
    private Persona persona;

    @Inject
    private Municipio municipio;
    @Inject
    private TipoDoc tipodoc;
    @Inject
    private Ocupacion ocupacion;
    @Inject
    private Parentesco parentesco;
    @Inject
    private NivelEducativo niveleducativo;

    @PostConstruct
    public void init() {
        lstpersona = personaEJB.findAll();
    }

    //getter y setter
    public List<Persona> getListpersona() {
        return listpersona;
    }

    public void setListpersona(List<Persona> listpersona) {
        this.listpersona = listpersona;
    }

    public Persona getSelpersona() {
        return selpersona;
    }

    public void setSelpersona(Persona selpersona) {
        this.selpersona = selpersona;
    }

    public List<Persona> getLstpersona() {
        return lstpersona;
    }

    public void setLstpersona(List<Persona> lstpersona) {
        this.lstpersona = lstpersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public NivelEducativo getNiveleducativo() {
        return niveleducativo;
    }

    public void setNiveleducativo(NivelEducativo niveleducativo) {
        this.niveleducativo = niveleducativo;
    }

    public Persona getPersonaseleccionada() {
        return personaseleccionada;
    }

    public void setPersonaseleccionada(Persona personaseleccionada) {
        this.personaseleccionada = personaseleccionada;
    }
 

    // Metodos
    public void setlistpersona(List<Persona> listpersona) {
        this.listpersona = listpersona;
    }

    public void registrar() {
        try {
            personaEJB.create(persona);
            lstpersona = personaEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Registro Falló."));
        }
    }

    public static int calcularEdad(String fecha) {
        String datetext = fecha;
        try {
            Calendar birth = new GregorianCalendar();
            Calendar today = new GregorianCalendar();
            int age = 0;
            int factor = 0;
            Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(datetext);
            Date currentDate = new Date(); //current date
            birth.setTime(birthDate);
            today.setTime(currentDate);
            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        factor = -1; //Aun no celebra su cumpleaÃ±os
                    }
                } else {
                    factor = -1; //Aun no celebra su cumpleaÃ±os
                }
            }
            age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
            return age;
        } catch (ParseException e) {
            return -1;
        }

    }

}