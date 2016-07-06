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
@Table(name = "caus_externa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CausExterna.findAll", query = "SELECT c FROM CausExterna c"),
    @NamedQuery(name = "CausExterna.findByIdCauxt", query = "SELECT c FROM CausExterna c WHERE c.idCauxt = :idCauxt"),
    @NamedQuery(name = "CausExterna.findByCodCauxt", query = "SELECT c FROM CausExterna c WHERE c.codCauxt = :codCauxt")})
public class CausExterna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cauxt")
    private Integer idCauxt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cod_cauxt")
    private String codCauxt;
    @OneToMany(mappedBy = "causExterna")
    private List<Historia> historiaList;

    public CausExterna() {
    }

    public CausExterna(Integer idCauxt) {
        this.idCauxt = idCauxt;
    }

    public CausExterna(Integer idCauxt, String codCauxt) {
        this.idCauxt = idCauxt;
        this.codCauxt = codCauxt;
    }

    public Integer getIdCauxt() {
        return idCauxt;
    }

    public void setIdCauxt(Integer idCauxt) {
        this.idCauxt = idCauxt;
    }

    public String getCodCauxt() {
        return codCauxt;
    }

    public void setCodCauxt(String codCauxt) {
        this.codCauxt = codCauxt;
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
        hash += (idCauxt != null ? idCauxt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CausExterna)) {
            return false;
        }
        CausExterna other = (CausExterna) object;
        if ((this.idCauxt == null && other.idCauxt != null) || (this.idCauxt != null && !this.idCauxt.equals(other.idCauxt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.CausExterna[ idCauxt=" + idCauxt + " ]";
    }

}
