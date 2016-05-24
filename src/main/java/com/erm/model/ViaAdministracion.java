/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erm.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "via_administracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViaAdministracion.findAll", query = "SELECT v FROM ViaAdministracion v"),
    @NamedQuery(name = "ViaAdministracion.findByIdVia", query = "SELECT v FROM ViaAdministracion v WHERE v.idVia = :idVia"),
    @NamedQuery(name = "ViaAdministracion.findByCodVia", query = "SELECT v FROM ViaAdministracion v WHERE v.codVia = :codVia"),
    @NamedQuery(name = "ViaAdministracion.findByDescripcioVia", query = "SELECT v FROM ViaAdministracion v WHERE v.descripcioVia = :descripcioVia")})
public class ViaAdministracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_via")
    private Integer idVia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_via")
    private String codVia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcio_via")
    private String descripcioVia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaAdministracion")
    private List<Medicamentos> medicamentosList;

    public ViaAdministracion() {
    }

    public ViaAdministracion(Integer idVia) {
        this.idVia = idVia;
    }

    public ViaAdministracion(Integer idVia, String codVia, String descripcioVia) {
        this.idVia = idVia;
        this.codVia = codVia;
        this.descripcioVia = descripcioVia;
    }

    public Integer getIdVia() {
        return idVia;
    }

    public void setIdVia(Integer idVia) {
        this.idVia = idVia;
    }

    public String getCodVia() {
        return codVia;
    }

    public void setCodVia(String codVia) {
        this.codVia = codVia;
    }

    public String getDescripcioVia() {
        return descripcioVia;
    }

    public void setDescripcioVia(String descripcioVia) {
        this.descripcioVia = descripcioVia;
    }

    @XmlTransient
    public List<Medicamentos> getMedicamentosList() {
        return medicamentosList;
    }

    public void setMedicamentosList(List<Medicamentos> medicamentosList) {
        this.medicamentosList = medicamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVia != null ? idVia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaAdministracion)) {
            return false;
        }
        ViaAdministracion other = (ViaAdministracion) object;
        if ((this.idVia == null && other.idVia != null) || (this.idVia != null && !this.idVia.equals(other.idVia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.ViaAdministracion[ idVia=" + idVia + " ]";
    }

}
