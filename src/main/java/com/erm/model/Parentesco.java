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
@Table(name = "parentesco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parentesco.findAll", query = "SELECT p FROM Parentesco p"),
    @NamedQuery(name = "Parentesco.findByIdparentesco", query = "SELECT p FROM Parentesco p WHERE p.idparentesco = :idparentesco"),
    @NamedQuery(name = "Parentesco.findByCodpar", query = "SELECT p FROM Parentesco p WHERE p.codpar = :codpar"),
    @NamedQuery(name = "Parentesco.findByParentesco", query = "SELECT p FROM Parentesco p WHERE p.parentesco = :parentesco")})
public class Parentesco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparentesco")
    private Integer idparentesco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codpar")
    private String codpar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "parentesco")
    private String parentesco;
    @OneToMany(mappedBy = "parentesco")
    private List<Persona> personaList;

    public Parentesco() {
    }

    public Parentesco(Integer idparentesco) {
        this.idparentesco = idparentesco;
    }

    public Parentesco(Integer idparentesco, String codpar, String parentesco) {
        this.idparentesco = idparentesco;
        this.codpar = codpar;
        this.parentesco = parentesco;
    }

    public Integer getIdparentesco() {
        return idparentesco;
    }

    public void setIdparentesco(Integer idparentesco) {
        this.idparentesco = idparentesco;
    }

    public String getCodpar() {
        return codpar;
    }

    public void setCodpar(String codpar) {
        this.codpar = codpar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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
        hash += (idparentesco != null ? idparentesco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parentesco)) {
            return false;
        }
        Parentesco other = (Parentesco) object;
        if ((this.idparentesco == null && other.idparentesco != null) || (this.idparentesco != null && !this.idparentesco.equals(other.idparentesco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Parentesco[ idparentesco=" + idparentesco + " ]";
    }
    
}
