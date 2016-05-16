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
@Table(name = "und_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UndMedida.findAll", query = "SELECT u FROM UndMedida u"),
    @NamedQuery(name = "UndMedida.findByIdundmedida", query = "SELECT u FROM UndMedida u WHERE u.idundmedida = :idundmedida"),
    @NamedQuery(name = "UndMedida.findByCodUndmedida", query = "SELECT u FROM UndMedida u WHERE u.codUndmedida = :codUndmedida"),
    @NamedQuery(name = "UndMedida.findByDesUndmedida", query = "SELECT u FROM UndMedida u WHERE u.desUndmedida = :desUndmedida")})
public class UndMedida implements Serializable {

    @OneToMany(mappedBy = "medidaEdad")
    private List<Persona> personaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idundmedida")
    private Integer idundmedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_undmedida")
    private String codUndmedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "des_undmedida")
    private String desUndmedida;

    public UndMedida() {
    }

    public UndMedida(Integer idundmedida) {
        this.idundmedida = idundmedida;
    }

    public UndMedida(Integer idundmedida, String codUndmedida, String desUndmedida) {
        this.idundmedida = idundmedida;
        this.codUndmedida = codUndmedida;
        this.desUndmedida = desUndmedida;
    }

    public Integer getIdundmedida() {
        return idundmedida;
    }

    public void setIdundmedida(Integer idundmedida) {
        this.idundmedida = idundmedida;
    }

    public String getCodUndmedida() {
        return codUndmedida;
    }

    public void setCodUndmedida(String codUndmedida) {
        this.codUndmedida = codUndmedida;
    }

    public String getDesUndmedida() {
        return desUndmedida;
    }

    public void setDesUndmedida(String desUndmedida) {
        this.desUndmedida = desUndmedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idundmedida != null ? idundmedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UndMedida)) {
            return false;
        }
        UndMedida other = (UndMedida) object;
        if ((this.idundmedida == null && other.idundmedida != null) || (this.idundmedida != null && !this.idundmedida.equals(other.idundmedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.UndMedida[ idundmedida=" + idundmedida + " ]";
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }
    
}
