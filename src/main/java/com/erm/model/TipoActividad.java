/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisgabriel
 */
@Entity
@Table(name = "tipo_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividad.findAll", query = "SELECT t FROM TipoActividad t"),
    @NamedQuery(name = "TipoActividad.findByIdtip", query = "SELECT t FROM TipoActividad t WHERE t.idtip = :idtip"),
    @NamedQuery(name = "TipoActividad.findByCodtipoActividad", query = "SELECT t FROM TipoActividad t WHERE t.codtipoActividad = :codtipoActividad"),
    @NamedQuery(name = "TipoActividad.findByDestipActividad", query = "SELECT t FROM TipoActividad t WHERE t.destipActividad = :destipActividad")})
public class TipoActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtip")
    private Integer idtip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codtipo_actividad")
    private String codtipoActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "destip_actividad")
    private String destipActividad;
    @OneToMany(mappedBy = "idtipActividad")
    private List<Actividades> actividadesList;

    public TipoActividad() {
    }

    public TipoActividad(Integer idtip) {
        this.idtip = idtip;
    }

    public TipoActividad(Integer idtip, String codtipoActividad, String destipActividad) {
        this.idtip = idtip;
        this.codtipoActividad = codtipoActividad;
        this.destipActividad = destipActividad;
    }

    public Integer getIdtip() {
        return idtip;
    }

    public void setIdtip(Integer idtip) {
        this.idtip = idtip;
    }

    public String getCodtipoActividad() {
        return codtipoActividad;
    }

    public void setCodtipoActividad(String codtipoActividad) {
        this.codtipoActividad = codtipoActividad;
    }

    public String getDestipActividad() {
        return destipActividad;
    }

    public void setDestipActividad(String destipActividad) {
        this.destipActividad = destipActividad;
    }

    @XmlTransient
    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtip != null ? idtip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividad)) {
            return false;
        }
        TipoActividad other = (TipoActividad) object;
        if ((this.idtip == null && other.idtip != null) || (this.idtip != null && !this.idtip.equals(other.idtip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.TipoActividad[ idtip=" + idtip + " ]";
    }
    
}
