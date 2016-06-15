package com.erm.controller;

import com.erm.ejb.TurnoFacadeLocal;
import com.erm.model.Turno;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



@Named
@ViewScoped
public class TurnoController implements Serializable{
    
   @EJB
   private TurnoFacadeLocal turnoEJB;
   private List<Turno> lstturno;   
   
   @Inject
   private Turno turno;
   
   @PostConstruct
   public void init(){
       lstturno = turnoEJB.findAll();
       
   }

    public List<Turno> getLstturno() {
        return lstturno;
    }

    public void setLstturno(List<Turno> lstturno) {
        this.lstturno = lstturno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
   
   public void mostrar(){
       lstturno = turnoEJB.findAll();
   }
}
