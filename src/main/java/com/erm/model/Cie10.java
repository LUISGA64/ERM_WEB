
package com.erm.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "cie10")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cie10.findAll", query = "SELECT c FROM Cie10 c"),
    @NamedQuery(name = "Cie10.findByIdcie10", query = "SELECT c FROM Cie10 c WHERE c.idcie10 = :idcie10"),
    @NamedQuery(name = "Cie10.findByCodCie10", query = "SELECT c FROM Cie10 c WHERE c.codCie10 = :codCie10"),
    @NamedQuery(name = "Cie10.findByDesCie10", query = "SELECT c FROM Cie10 c WHERE c.desCie10 = :desCie10"),
    @NamedQuery(name = "Cie10.findByAlerta", query = "SELECT c FROM Cie10 c WHERE c.alerta = :alerta")})
public class Cie10 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcie10")
    private Integer idcie10;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_cie10")
    private String codCie10;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 270)
    @Column(name = "des_cie10")
    private String desCie10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alerta")
    private Character alerta;

    public Cie10() {
    }

    public Cie10(Integer idcie10) {
        this.idcie10 = idcie10;
    }

    public Cie10(Integer idcie10, String codCie10, String desCie10, Character alerta) {
        this.idcie10 = idcie10;
        this.codCie10 = codCie10;
        this.desCie10 = desCie10;
        this.alerta = alerta;
    }

    public Integer getIdcie10() {
        return idcie10;
    }

    public void setIdcie10(Integer idcie10) {
        this.idcie10 = idcie10;
    }

    public String getCodCie10() {
        return codCie10;
    }

    public void setCodCie10(String codCie10) {
        this.codCie10 = codCie10;
    }

    public String getDesCie10() {
        return desCie10;
    }

    public void setDesCie10(String desCie10) {
        this.desCie10 = desCie10;
    }

    public Character getAlerta() {
        return alerta;
    }

    public void setAlerta(Character alerta) {
        this.alerta = alerta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcie10 != null ? idcie10.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cie10)) {
            return false;
        }
        Cie10 other = (Cie10) object;
        if ((this.idcie10 == null && other.idcie10 != null) || (this.idcie10 != null && !this.idcie10.equals(other.idcie10))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Cie10[ idcie10=" + idcie10 + " ]";
    }
    
}
