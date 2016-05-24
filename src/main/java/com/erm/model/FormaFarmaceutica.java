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
@Table(name = "forma_farmaceutica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaFarmaceutica.findAll", query = "SELECT f FROM FormaFarmaceutica f"),
    @NamedQuery(name = "FormaFarmaceutica.findByIdFormaf", query = "SELECT f FROM FormaFarmaceutica f WHERE f.idFormaf = :idFormaf"),
    @NamedQuery(name = "FormaFarmaceutica.findByCodFormaFarma", query = "SELECT f FROM FormaFarmaceutica f WHERE f.codFormaFarma = :codFormaFarma"),
    @NamedQuery(name = "FormaFarmaceutica.findByFormaFarma", query = "SELECT f FROM FormaFarmaceutica f WHERE f.formaFarma = :formaFarma")})
public class FormaFarmaceutica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formaf")
    private Integer idFormaf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_forma_farma")
    private String codFormaFarma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "forma_farma")
    private String formaFarma;
    @OneToMany(mappedBy = "formaFarmaceutica")
    private List<Medicamentos> medicamentosList;

    public FormaFarmaceutica() {
    }

    public FormaFarmaceutica(Integer idFormaf) {
        this.idFormaf = idFormaf;
    }

    public FormaFarmaceutica(Integer idFormaf, String codFormaFarma, String formaFarma) {
        this.idFormaf = idFormaf;
        this.codFormaFarma = codFormaFarma;
        this.formaFarma = formaFarma;
    }

    public Integer getIdFormaf() {
        return idFormaf;
    }

    public void setIdFormaf(Integer idFormaf) {
        this.idFormaf = idFormaf;
    }

    public String getCodFormaFarma() {
        return codFormaFarma;
    }

    public void setCodFormaFarma(String codFormaFarma) {
        this.codFormaFarma = codFormaFarma;
    }

    public String getFormaFarma() {
        return formaFarma;
    }

    public void setFormaFarma(String formaFarma) {
        this.formaFarma = formaFarma;
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
        hash += (idFormaf != null ? idFormaf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaFarmaceutica)) {
            return false;
        }
        FormaFarmaceutica other = (FormaFarmaceutica) object;
        if ((this.idFormaf == null && other.idFormaf != null) || (this.idFormaf != null && !this.idFormaf.equals(other.idFormaf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.FormaFarmaceutica[ idFormaf=" + idFormaf + " ]";
    }

}
