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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "medicamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findByIdMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "Medicamentos.findByProducto", query = "SELECT m FROM Medicamentos m WHERE m.producto = :producto"),
    @NamedQuery(name = "Medicamentos.findByExpediente", query = "SELECT m FROM Medicamentos m WHERE m.expediente = :expediente"),
    @NamedQuery(name = "Medicamentos.findByConsecutivo", query = "SELECT m FROM Medicamentos m WHERE m.consecutivo = :consecutivo"),
    @NamedQuery(name = "Medicamentos.findByPresentacion", query = "SELECT m FROM Medicamentos m WHERE m.presentacion = :presentacion"),
    @NamedQuery(name = "Medicamentos.findByAtc", query = "SELECT m FROM Medicamentos m WHERE m.atc = :atc"),
    @NamedQuery(name = "Medicamentos.findByDescripcionAtc", query = "SELECT m FROM Medicamentos m WHERE m.descripcionAtc = :descripcionAtc"),
    @NamedQuery(name = "Medicamentos.findByPrincipioActivo", query = "SELECT m FROM Medicamentos m WHERE m.principioActivo = :principioActivo"),
    @NamedQuery(name = "Medicamentos.findByPos", query = "SELECT m FROM Medicamentos m WHERE m.pos = :pos")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamento")
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "producto")
    private String producto;
    @Size(max = 20)
    @Column(name = "expediente")
    private String expediente;
    @Size(max = 2)
    @Column(name = "consecutivo")
    private String consecutivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "presentacion")
    private String presentacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "atc")
    private String atc;
    @Size(max = 200)
    @Column(name = "descripcion_atc")
    private String descripcionAtc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "principio_activo")
    private String principioActivo;
    @Column(name = "pos")
    private Boolean pos;
    @JoinColumn(name = "forma_farmaceutica", referencedColumnName = "id_formaf")
    @ManyToOne
    private FormaFarmaceutica formaFarmaceutica;
    @JoinColumn(name = "unidad_medida", referencedColumnName = "id_und")
    @ManyToOne
    private UnidadMedida unidadMedida;
    @JoinColumn(name = "via_administracion", referencedColumnName = "id_via")
    @ManyToOne(optional = false)
    private ViaAdministracion viaAdministracion;

    public Medicamentos() {
    }

    public Medicamentos(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamentos(Integer idMedicamento, String producto, String presentacion, String atc, String principioActivo) {
        this.idMedicamento = idMedicamento;
        this.producto = producto;
        this.presentacion = presentacion;
        this.atc = atc;
        this.principioActivo = principioActivo;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getDescripcionAtc() {
        return descripcionAtc;
    }

    public void setDescripcionAtc(String descripcionAtc) {
        this.descripcionAtc = descripcionAtc;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public Boolean getPos() {
        return pos;
    }

    public void setPos(Boolean pos) {
        this.pos = pos;
    }

    public FormaFarmaceutica getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public ViaAdministracion getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(ViaAdministracion viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
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
