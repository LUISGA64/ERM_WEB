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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u"),
    @NamedQuery(name = "UnidadMedida.findByIdUnd", query = "SELECT u FROM UnidadMedida u WHERE u.idUnd = :idUnd"),
    @NamedQuery(name = "UnidadMedida.findByCodUnd", query = "SELECT u FROM UnidadMedida u WHERE u.codUnd = :codUnd"),
    @NamedQuery(name = "UnidadMedida.findByDesUnd", query = "SELECT u FROM UnidadMedida u WHERE u.desUnd = :desUnd")})
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_und")
    private Integer idUnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_und")
    private String codUnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "des_und")
    private String desUnd;
    @OneToMany(mappedBy = "unidadMedida")
    private List<Medicamentos> medicamentosList;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idUnd) {
        this.idUnd = idUnd;
    }

    public UnidadMedida(Integer idUnd, String codUnd, String desUnd) {
        this.idUnd = idUnd;
        this.codUnd = codUnd;
        this.desUnd = desUnd;
    }

    public Integer getIdUnd() {
        return idUnd;
    }

    public void setIdUnd(Integer idUnd) {
        this.idUnd = idUnd;
    }

    public String getCodUnd() {
        return codUnd;
    }

    public void setCodUnd(String codUnd) {
        this.codUnd = codUnd;
    }

    public String getDesUnd() {
        return desUnd;
    }

    public void setDesUnd(String desUnd) {
        this.desUnd = desUnd;
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
        hash += (idUnd != null ? idUnd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idUnd == null && other.idUnd != null) || (this.idUnd != null && !this.idUnd.equals(other.idUnd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.UnidadMedida[ idUnd=" + idUnd + " ]";
    }

}
