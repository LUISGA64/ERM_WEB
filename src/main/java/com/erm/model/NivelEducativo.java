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
@Table(name = "nivel_educativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEducativo.findAll", query = "SELECT n FROM NivelEducativo n"),
    @NamedQuery(name = "NivelEducativo.findByIdniv", query = "SELECT n FROM NivelEducativo n WHERE n.idniv = :idniv"),
    @NamedQuery(name = "NivelEducativo.findByCodigoniv", query = "SELECT n FROM NivelEducativo n WHERE n.codigoniv = :codigoniv"),
    @NamedQuery(name = "NivelEducativo.findByDesniv", query = "SELECT n FROM NivelEducativo n WHERE n.desniv = :desniv")})
public class NivelEducativo implements Serializable {

    @OneToMany(mappedBy = "idniv")
    private List<Persona> personaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idniv")
    private Integer idniv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigoniv")
    private String codigoniv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "desniv")
    private String desniv;

    public NivelEducativo() {
    }

    public NivelEducativo(Integer idniv) {
        this.idniv = idniv;
    }

    public NivelEducativo(Integer idniv, String codigoniv, String desniv) {
        this.idniv = idniv;
        this.codigoniv = codigoniv;
        this.desniv = desniv;
    }

    public Integer getIdniv() {
        return idniv;
    }

    public void setIdniv(Integer idniv) {
        this.idniv = idniv;
    }

    public String getCodigoniv() {
        return codigoniv;
    }

    public void setCodigoniv(String codigoniv) {
        this.codigoniv = codigoniv;
    }

    public String getDesniv() {
        return desniv;
    }

    public void setDesniv(String desniv) {
        this.desniv = desniv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idniv != null ? idniv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEducativo)) {
            return false;
        }
        NivelEducativo other = (NivelEducativo) object;
        if ((this.idniv == null && other.idniv != null) || (this.idniv != null && !this.idniv.equals(other.idniv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.NivelEducativo[ idniv=" + idniv + " ]";
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
    
}
