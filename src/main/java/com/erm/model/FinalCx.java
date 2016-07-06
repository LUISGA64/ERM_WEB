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


@Entity
@Table(name = "final_cx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalCx.findAll", query = "SELECT f FROM FinalCx f"),
    @NamedQuery(name = "FinalCx.findByIdFinalcx", query = "SELECT f FROM FinalCx f WHERE f.idFinalcx = :idFinalcx"),
    @NamedQuery(name = "FinalCx.findByFinalidadCx", query = "SELECT f FROM FinalCx f WHERE f.finalidadCx = :finalidadCx")})
public class FinalCx implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_finalcx")
    private Integer idFinalcx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "finalidad_cx")
    private String finalidadCx;
    @OneToMany(mappedBy = "finalidadCx")
    private List<Historia> historiaList;

    public FinalCx() {
    }

    public FinalCx(Integer idFinalcx) {
        this.idFinalcx = idFinalcx;
    }

    public FinalCx(Integer idFinalcx, String finalidadCx) {
        this.idFinalcx = idFinalcx;
        this.finalidadCx = finalidadCx;
    }

    public Integer getIdFinalcx() {
        return idFinalcx;
    }

    public void setIdFinalcx(Integer idFinalcx) {
        this.idFinalcx = idFinalcx;
    }

    public String getFinalidadCx() {
        return finalidadCx;
    }

    public void setFinalidadCx(String finalidadCx) {
        this.finalidadCx = finalidadCx;
    }

    @XmlTransient
    public List<Historia> getHistoriaList() {
        return historiaList;
    }

    public void setHistoriaList(List<Historia> historiaList) {
        this.historiaList = historiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFinalcx != null ? idFinalcx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalCx)) {
            return false;
        }
        FinalCx other = (FinalCx) object;
        if ((this.idFinalcx == null && other.idFinalcx != null) || (this.idFinalcx != null && !this.idFinalcx.equals(other.idFinalcx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.FinalCx[ idFinalcx=" + idFinalcx + " ]";
    }

}
