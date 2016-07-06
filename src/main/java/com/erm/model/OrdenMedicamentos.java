/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "orden_medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenMedicamentos.findAll", query = "SELECT o FROM OrdenMedicamentos o"),
    @NamedQuery(name = "OrdenMedicamentos.findByIdOrdenMed", query = "SELECT o FROM OrdenMedicamentos o WHERE o.idOrdenMed = :idOrdenMed"),
    @NamedQuery(name = "OrdenMedicamentos.findByCantidad", query = "SELECT o FROM OrdenMedicamentos o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenMedicamentos.findByDosis", query = "SELECT o FROM OrdenMedicamentos o WHERE o.dosis = :dosis")})
public class OrdenMedicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_med")
    private Integer idOrdenMed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dosis")
    private BigDecimal dosis;

    public OrdenMedicamentos() {
    }

    public OrdenMedicamentos(Integer idOrdenMed) {
        this.idOrdenMed = idOrdenMed;
    }

    public OrdenMedicamentos(Integer idOrdenMed, int cantidad) {
        this.idOrdenMed = idOrdenMed;
        this.cantidad = cantidad;
    }

    public Integer getIdOrdenMed() {
        return idOrdenMed;
    }

    public void setIdOrdenMed(Integer idOrdenMed) {
        this.idOrdenMed = idOrdenMed;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getDosis() {
        return dosis;
    }

    public void setDosis(BigDecimal dosis) {
        this.dosis = dosis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenMed != null ? idOrdenMed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenMedicamentos)) {
            return false;
        }
        OrdenMedicamentos other = (OrdenMedicamentos) object;
        if ((this.idOrdenMed == null && other.idOrdenMed != null) || (this.idOrdenMed != null && !this.idOrdenMed.equals(other.idOrdenMed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.OrdenMedicamentos[ idOrdenMed=" + idOrdenMed + " ]";
    }

}
