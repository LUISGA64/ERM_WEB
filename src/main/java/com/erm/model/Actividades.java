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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisgabriel
 */
@Entity
@Table(name = "actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a"),
    @NamedQuery(name = "Actividades.findByIdactividad", query = "SELECT a FROM Actividades a WHERE a.idactividad = :idactividad"),
    @NamedQuery(name = "Actividades.findByCodActividad", query = "SELECT a FROM Actividades a WHERE a.codActividad = :codActividad"),
    @NamedQuery(name = "Actividades.findByDesActividad", query = "SELECT a FROM Actividades a WHERE a.desActividad = :desActividad")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactividad")
    private Integer idactividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cod_actividad")
    private String codActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des_actividad")
    private String desActividad;
    @JoinColumn(name = "idtip_actividad", referencedColumnName = "idtip")
    @ManyToOne
    private TipoActividad idtipActividad;

    public Actividades() {
    }

    public Actividades(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public Actividades(Integer idactividad, String codActividad, String desActividad) {
        this.idactividad = idactividad;
        this.codActividad = codActividad;
        this.desActividad = desActividad;
    }

    public Integer getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getDesActividad() {
        return desActividad;
    }

    public void setDesActividad(String desActividad) {
        this.desActividad = desActividad;
    }

    public TipoActividad getIdtipActividad() {
        return idtipActividad;
    }

    public void setIdtipActividad(TipoActividad idtipActividad) {
        this.idtipActividad = idtipActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactividad != null ? idactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.idactividad == null && other.idactividad != null) || (this.idactividad != null && !this.idactividad.equals(other.idactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Actividades[ idactividad=" + idactividad + " ]";
    }
    
}
