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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ocupacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocupacion.findAll", query = "SELECT o FROM Ocupacion o"),
    @NamedQuery(name = "Ocupacion.findByIdocupacion", query = "SELECT o FROM Ocupacion o WHERE o.idocupacion = :idocupacion"),
    @NamedQuery(name = "Ocupacion.findByCodigoOcp", query = "SELECT o FROM Ocupacion o WHERE o.codigoOcp = :codigoOcp"),
    @NamedQuery(name = "Ocupacion.findByDescripcionOcp", query = "SELECT o FROM Ocupacion o WHERE o.descripcionOcp = :descripcionOcp")})
public class Ocupacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idocupacion")
    private Integer idocupacion;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_ocp")
    private String codigoOcp;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion_ocp")
    private String descripcionOcp;
    
    
    
    @OneToMany(mappedBy = "idocupacion")
    private List<Persona> personaList;

    public Ocupacion() {
    }

    public Ocupacion(Integer idocupacion) {
        this.idocupacion = idocupacion;
    }

    public Ocupacion(Integer idocupacion, String codigoOcp, String descripcionOcp) {
        this.idocupacion = idocupacion;
        this.codigoOcp = codigoOcp;
        this.descripcionOcp = descripcionOcp;
    }

    public Integer getIdocupacion() {
        return idocupacion;
    }

    public void setIdocupacion(Integer idocupacion) {
        this.idocupacion = idocupacion;
    }

    public String getCodigoOcp() {
        return codigoOcp;
    }

    public void setCodigoOcp(String codigoOcp) {
        this.codigoOcp = codigoOcp;
    }

    public String getDescripcionOcp() {
        return descripcionOcp;
    }

    public void setDescripcionOcp(String descripcionOcp) {
        this.descripcionOcp = descripcionOcp;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idocupacion != null ? idocupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocupacion)) {
            return false;
        }
        Ocupacion other = (Ocupacion) object;
        if ((this.idocupacion == null && other.idocupacion != null) || (this.idocupacion != null && !this.idocupacion.equals(other.idocupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Ocupacion[ idocupacion=" + idocupacion + " ]";
    }
    
}
