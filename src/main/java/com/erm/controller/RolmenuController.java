package com.erm.controller;

import com.erm.ejb.RolMenuFacadeLocal;
import com.erm.model.Menu;
import com.erm.model.Rol;
import com.erm.model.RolMenu;
import com.erm.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@ViewScoped
public class RolmenuController implements Serializable {

    @EJB
    private RolMenuFacadeLocal EJBrolmenu;
    private List<RolMenu> lstrolmenu;
    private MenuModel model;

    @Inject
    private Menu menu;

    @Inject
    private Rol rol;

    @PostConstruct
    public void init() {
        lstrolmenu = EJBrolmenu.findAll();
        model = new DefaultMenuModel();
        this.listarMenus();
        this.permisos();
    }

    public List<RolMenu> getLstrolmenu() {
        return lstrolmenu;
    }

    public void setLstrolmenu(List<RolMenu> lstrolmenu) {
        this.lstrolmenu = lstrolmenu;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public void listarMenus(){
        lstrolmenu = EJBrolmenu.findAll();
    }
    
    public void permisos() {        
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        for (RolMenu m : lstrolmenu) {
            System.out.println("menu: " + m.getIdMenu().getDetMenu()+" Tipo menu: "+m.getIdMenu().getTipMenu());
            if (m.getIdMenu().getTipMenu().equals("S")){
                DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getIdMenu().getDetMenu());
                for (RolMenu i : lstrolmenu) {
                    System.out.println("I: "+i);
                    Menu subMenu = i.getIdMenu().getSubmenu();
                    if (subMenu != null && subMenu.getIdMenu().getIdmenu() == m.getIdMenu().getIdmenu()) {
                        DefaultMenuItem item = new DefaultMenuItem(i.getIdMenu().getDetMenu());
                        firstSubMenu.addElement(item);
                    }
                }
                model.addElement(firstSubMenu);
            }else{
                DefaultMenuItem item = new DefaultMenuItem(m.getIdMenu().getDetMenu());
                model.addElement(item);
            }
        }
    }
}