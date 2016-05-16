/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erm.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "rol_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolMenu.findAll", query = "SELECT r FROM RolMenu r"),
    @NamedQuery(name = "RolMenu.findByIdrolmenu", query = "SELECT r FROM RolMenu r WHERE r.idrolmenu = :idrolmenu"),
    @NamedQuery(name = "RolMenu.findByIcono", query = "SELECT r FROM RolMenu r WHERE r.icono = :icono")})
public class RolMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrolmenu")
    private Integer idrolmenu;
    @Size(max = 200)
    @Column(name = "icono")
    private String icono;
    @JoinColumn(name = "id_menu", referencedColumnName = "idmenu")
    @ManyToOne(optional = false)
    private Menu idMenu;
    @JoinColumn(name = "idrol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idrol;

    public RolMenu() {
    }

    public RolMenu(Integer idrolmenu) {
        this.idrolmenu = idrolmenu;
    }

    public Integer getIdrolmenu() {
        return idrolmenu;
    }

    public void setIdrolmenu(Integer idrolmenu) {
        this.idrolmenu = idrolmenu;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolmenu != null ? idrolmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolMenu)) {
            return false;
        }
        RolMenu other = (RolMenu) object;
        if ((this.idrolmenu == null && other.idrolmenu != null) || (this.idrolmenu != null && !this.idrolmenu.equals(other.idrolmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.RolMenu[ idrolmenu=" + idrolmenu + " ]";
    }

}
