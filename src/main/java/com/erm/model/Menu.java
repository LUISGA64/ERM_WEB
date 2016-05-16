/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erm.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdmenu", query = "SELECT m FROM Menu m WHERE m.idmenu = :idmenu"),
    @NamedQuery(name = "Menu.findByDetMenu", query = "SELECT m FROM Menu m WHERE m.detMenu = :detMenu"),
    @NamedQuery(name = "Menu.findByTipMenu", query = "SELECT m FROM Menu m WHERE m.tipMenu = :tipMenu")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmenu")
    private Integer idmenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "det_menu")
    private String detMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip_menu")
    private Character tipMenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<Menu> menuList;
    @JoinColumn(name = "id_menu", referencedColumnName = "idmenu")
    @ManyToOne(optional = false)
    private Menu idMenu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<RolMenu> rolMenuList;

    public Menu() {
    }

    public Menu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Menu(Integer idmenu, String detMenu, Character tipMenu) {
        this.idmenu = idmenu;
        this.detMenu = detMenu;
        this.tipMenu = tipMenu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getDetMenu() {
        return detMenu;
    }

    public void setDetMenu(String detMenu) {
        this.detMenu = detMenu;
    }

    public Character getTipMenu() {
        return tipMenu;
    }

    public void setTipMenu(Character tipMenu) {
        this.tipMenu = tipMenu;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    @XmlTransient
    public List<RolMenu> getRolMenuList() {
        return rolMenuList;
    }

    public void setRolMenuList(List<RolMenu> rolMenuList) {
        this.rolMenuList = rolMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Menu[ idmenu=" + idmenu + " ]";
    }

    public Menu getSubmenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
