
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findByIdmedico", query = "SELECT m FROM Medico m WHERE m.idmedico = :idmedico"),
    @NamedQuery(name = "Medico.findByNombre1", query = "SELECT m FROM Medico m WHERE m.nombre1 = :nombre1"),
    @NamedQuery(name = "Medico.findByNombre2", query = "SELECT m FROM Medico m WHERE m.nombre2 = :nombre2"),
    @NamedQuery(name = "Medico.findByApellido1", query = "SELECT m FROM Medico m WHERE m.apellido1 = :apellido1"),
    @NamedQuery(name = "Medico.findByApellido2", query = "SELECT m FROM Medico m WHERE m.apellido2 = :apellido2"),
    @NamedQuery(name = "Medico.findByRegistro", query = "SELECT m FROM Medico m WHERE m.registro = :registro"),
    @NamedQuery(name = "Medico.findByIdeMed", query = "SELECT m FROM Medico m WHERE m.ideMed = :ideMed"),
    @NamedQuery(name = "Medico.findByEstado", query = "SELECT m FROM Medico m WHERE m.estado = :estado"),
    @NamedQuery(name = "Medico.findByTipodoc", query = "SELECT m from Medico m WHERE m.tipoDoc = :tipodoc"),
    @NamedQuery(name = "Medico.findByEspecialidad", query = "SELECT m from Medico m WHERE m.especialidad = :especialidad")})
    


public class Medico implements Serializable {

    @Lob
    @Column(name = "firma")
    private byte[] firma;
    @OneToMany(mappedBy = "idMedico")
    private List<Historia> historiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedico")
    private List<Agenda> agendaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedico")
    private Integer idmedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre1")
    private String nombre1;
    @Size(max = 15)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 15)
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "registro")
    private String registro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ide_med")
    private String ideMed;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "especialidad", referencedColumnName = "idespecialidad")
    @ManyToOne
    private Especialidad especialidad;
    @JoinColumn(name = "tipo_doc", referencedColumnName = "tipodoc")
    @ManyToOne
    private TipoDoc tipoDoc;

    public Medico() {
    }

    public Medico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Medico(Integer idmedico, String nombre1, String apellido1, String registro, String ideMed) {
        this.idmedico = idmedico;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.registro = registro;
        this.ideMed = ideMed;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getIdeMed() {
        return ideMed;
    }

    public void setIdeMed(String ideMed) {
        this.ideMed = ideMed;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Medico[ idmedico=" + idmedico + " ]";
    }


    @XmlTransient
    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(List<Agenda> agendaList) {
        this.agendaList = agendaList;
    }


    @XmlTransient
    public List<Historia> getHistoriaList() {
        return historiaList;
    }

    public void setHistoriaList(List<Historia> historiaList) {
        this.historiaList = historiaList;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }
    
}
