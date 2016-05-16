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

/**
 *
 * @author luisgabriel
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByIdMunicipio", query = "SELECT m FROM Municipio m WHERE m.idMunicipio = :idMunicipio"),
    @NamedQuery(name = "Municipio.findByCodigoMpio", query = "SELECT m FROM Municipio m WHERE m.codigoMpio = :codigoMpio"),
    @NamedQuery(name = "Municipio.findByDesMpio", query = "SELECT m FROM Municipio m WHERE m.desMpio = :desMpio")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_municipio")
    private Integer idMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_mpio")
    private String codigoMpio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "des_mpio")
    private String desMpio;
    @OneToMany(mappedBy = "idMunicipio")
    private List<Persona> personaList;
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne
    private Departamento iddepartamento;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipio(Integer idMunicipio, String codigoMpio, String desMpio) {
        this.idMunicipio = idMunicipio;
        this.codigoMpio = codigoMpio;
        this.desMpio = desMpio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getCodigoMpio() {
        return codigoMpio;
    }

    public void setCodigoMpio(String codigoMpio) {
        this.codigoMpio = codigoMpio;
    }

    public String getDesMpio() {
        return desMpio;
    }

    public void setDesMpio(String desMpio) {
        this.desMpio = desMpio;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Departamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
