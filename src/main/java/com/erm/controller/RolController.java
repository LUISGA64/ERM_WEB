package com.erm.controller;

import com.erm.ejb.RolFacadeLocal;
import com.erm.model.Rol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class RolController implements Serializable{
    
    @EJB
    private RolFacadeLocal rolEJB;
    private List<Rol> lstrol;
    private Rol rolsel;
    
    @Inject
    private Rol rol;
    
    @PostConstruct
    public void init(){
        lstrol =rolEJB.findAll();
    }
    
    //Getter && Setter

    public List<Rol> getLstrol() {
        return lstrol;
    }

    public void setLstrol(List<Rol> lstrol) {
        this.lstrol = lstrol;
    }

    public Rol getRolsel() {
        return rolsel;
    }

    public void setRolsel(Rol rolsel) {
        this.rolsel = rolsel;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
