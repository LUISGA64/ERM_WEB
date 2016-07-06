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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "ordenes_medicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesMedicas.findAll", query = "SELECT o FROM OrdenesMedicas o"),
    @NamedQuery(name = "OrdenesMedicas.findByIdOrden", query = "SELECT o FROM OrdenesMedicas o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenesMedicas.findByCantidad", query = "SELECT o FROM OrdenesMedicas o WHERE o.cantidad = :cantidad")})
public class OrdenesMedicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;

    public OrdenesMedicas() {
    }

    public OrdenesMedicas(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdenesMedicas(Integer idOrden, int cantidad) {
        this.idOrden = idOrden;
        this.cantidad = cantidad;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesMedicas)) {
            return false;
        }
        OrdenesMedicas other = (OrdenesMedicas) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.OrdenesMedicas[ idOrden=" + idOrden + " ]";
    }

}
