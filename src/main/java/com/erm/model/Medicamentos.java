/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisgabriel
 */
@Entity
@Table(name = "medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findByIdMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "Medicamentos.findByCodigoMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.codigoMedicamento = :codigoMedicamento"),
    @NamedQuery(name = "Medicamentos.findByNombreGenerico", query = "SELECT m FROM Medicamentos m WHERE m.nombreGenerico = :nombreGenerico"),
    @NamedQuery(name = "Medicamentos.findByActivo", query = "SELECT m FROM Medicamentos m WHERE m.activo = :activo"),
    @NamedQuery(name = "Medicamentos.findByAltoCosto", query = "SELECT m FROM Medicamentos m WHERE m.altoCosto = :altoCosto"),
    @NamedQuery(name = "Medicamentos.findByPos", query = "SELECT m FROM Medicamentos m WHERE m.pos = :pos")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medicamento")
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "codigo_medicamento")
    private String codigoMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_generico")
    private String nombreGenerico;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "alto_costo")
    private Boolean altoCosto;
    @Column(name = "pos")
    private Boolean pos;

    public Medicamentos() {
    }

    public Medicamentos(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamentos(Integer idMedicamento, String codigoMedicamento, String nombreGenerico) {
        this.idMedicamento = idMedicamento;
        this.codigoMedicamento = codigoMedicamento;
        this.nombreGenerico = nombreGenerico;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(String codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getAltoCosto() {
        return altoCosto;
    }

    public void setAltoCosto(Boolean altoCosto) {
        this.altoCosto = altoCosto;
    }

    public Boolean getPos() {
        return pos;
    }

    public void setPos(Boolean pos) {
        this.pos = pos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Medicamentos[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
