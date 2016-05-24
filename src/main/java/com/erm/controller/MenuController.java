package com.erm.controller;

import com.erm.ejb.MenuFacadeLocal;
import com.erm.model.Menu;
import com.erm.model.Rol;
import com.erm.model.RolMenu;
import com.erm.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private MenuFacadeLocal EJBmenu;
    private List<Menu> lstmenu;
    private MenuModel model;
    private List<RolMenu> lstrm;

    @Inject
    private Usuario usuario;

    @Inject
    private RolMenu rolmenu;

    @Inject
    private Rol rol;

    @Inject
    private Menu menu;

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        //this.permisos();

    }

    public List<RolMenu> getLstrm() {
        return lstrm;
    }

    public void setLstrm(List<RolMenu> lstrm) {
        this.lstrm = lstrm;
    }

    public List<Menu> getLstmenu() {
        return lstmenu;
    }

    public void setLstmenu(List<Menu> lstmenu) {
        this.lstmenu = lstmenu;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RolMenu getRolmenu() {
        return rolmenu;
    }

    public void setRolmenu(RolMenu rolmenu) {
        this.rolmenu = rolmenu;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void listarMenus() {
        try {
            lstmenu = EJBmenu.findAll();

        } catch (Exception e) {
            // mensaje
        }
    }

    public void permisos() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        for (Menu m : lstmenu) {
            if (m.getTipMenu().equals("S")) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getDetMenu());
                System.out.println("*** menu: " + m.getDetMenu());
                for (Menu i : lstmenu) {
                    Menu subMenu = i.getSubmenu();
                    if (subMenu != null) {
                        if (subMenu.getIdMenu().getIdmenu() == m.getIdMenu().getIdmenu()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getDetMenu());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            } else {
                DefaultMenuItem item = new DefaultMenuItem(m.getDetMenu());
                model.addElement(item);
            }
        }

        for (RolMenu m : lstrm) {
            if (m.getIdMenu().getTipMenu().equals("S") && m.getIdrol().getRol().equals(us.getIdrol())) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getIdMenu().getDetMenu());
            }
        }
    }
}
