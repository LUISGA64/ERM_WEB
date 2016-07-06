package com.erm.controller;

import com.erm.ejb.FinalCxFacadeLocal;
import com.erm.model.FinalCx;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class FinalidadCxController implements Serializable{
    
    @EJB
    private FinalCxFacadeLocal finalidadCxEJB;
    private List<FinalCx> lstfinalidadcx;
    private FinalCx selfinalidad;
    
    
   @Inject
   private FinalCx finalcx;
   
   @PostConstruct
   public void init(){
       lstfinalidadcx = finalidadCxEJB.findAll();
   }
   
   /*Metodos Setter && Getter*/

    public List<FinalCx> getLstfinalidadcx() {
        return lstfinalidadcx;
    }

    public void setLstfinalidadcx(List<FinalCx> lstfinalidadcx) {
        this.lstfinalidadcx = lstfinalidadcx;
    }

    public FinalCx getSelfinalidad() {
        return selfinalidad;
    }

    public void setSelfinalidad(FinalCx selfinalidad) {
        this.selfinalidad = selfinalidad;
    }

    public FinalCx getFinalcx() {
        return finalcx;
    }

    public void setFinalcx(FinalCx finalcx) {
        this.finalcx = finalcx;
    }
   }
