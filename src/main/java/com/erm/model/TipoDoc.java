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
@Table(name = "tipo_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDoc.findAll", query = "SELECT t FROM TipoDoc t"),
    @NamedQuery(name = "TipoDoc.findByTipodoc", query = "SELECT t FROM TipoDoc t WHERE t.tipodoc = :tipodoc"),
    @NamedQuery(name = "TipoDoc.findByCodoc", query = "SELECT t FROM TipoDoc t WHERE t.codoc = :codoc"),
    @NamedQuery(name = "TipoDoc.findByDocumento", query = "SELECT t FROM TipoDoc t WHERE t.documento = :documento")})
public class TipoDoc implements Serializable {

    @OneToMany(mappedBy = "tipodocUsuario")
    private List<Usuario> usuarioList;

    @OneToMany(mappedBy = "tipoDoc")
    private List<Medico> medicoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipodoc")
    private Integer tipodoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codoc")
    private String codoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "documento")
    private String documento;
    @OneToMany(mappedBy = "tipoDoc")
    private List<Persona> personaList;

    public TipoDoc() {
    }

    public TipoDoc(Integer tipodoc) {
        this.tipodoc = tipodoc;
    }

    public TipoDoc(Integer tipodoc, String codoc, String documento) {
        this.tipodoc = tipodoc;
        this.codoc = codoc;
        this.documento = documento;
    }

    public Integer getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(Integer tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getCodoc() {
        return codoc;
    }

    public void setCodoc(String codoc) {
        this.codoc = codoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
        hash += (tipodoc != null ? tipodoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDoc)) {
            return false;
        }
        TipoDoc other = (TipoDoc) object;
        if ((this.tipodoc == null && other.tipodoc != null) || (this.tipodoc != null && !this.tipodoc.equals(other.tipodoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.TipoDoc[ tipodoc=" + tipodoc + " ]";
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
}
