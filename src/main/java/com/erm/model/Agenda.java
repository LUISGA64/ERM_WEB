
package com.erm.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByIdAgenda", query = "SELECT a FROM Agenda a WHERE a.idAgenda = :idAgenda"),
    /*@NamedQuery(name = "Agenda.findByFecha", query = "SELECT a FROM Agenda a WHERE a.fecha = :fecha"),*/
    @NamedQuery(name = "Agenda.findByHora", query = "SELECT a FROM Agenda a WHERE a.hora = :hora"),
    @NamedQuery(name = "Agenda.findByFechaCita", query = "SELECT a FROM Agenda a WHERE a.fechaCita = :fechaCita"),
    @NamedQuery(name = "Agenda.findByEstadoCita", query = "SELECT a FROM Agenda a WHERE a.estadoCita = :estadoCita"),
    @NamedQuery(name = "Agenda.findByCitaAtendida", query = "SELECT a FROM Agenda a WHERE a.citaAtendida = :citaAtendida")})
public class Agenda implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_agenda")
    private Integer idAgenda;
    /* @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    */
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cita")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;
    
    
    @Column(name = "estado_cita")
    private Boolean estadoCita;
    @Column(name = "cita_atendida")
    private Boolean citaAtendida;
    
    
    @JoinColumn(name = "id_medico", referencedColumnName = "idmedico")
    @ManyToOne(optional = false)
    private Medico idMedico;
    @JoinColumn(name = "id_paciente", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idPaciente;

    public Agenda() {
    }

    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Agenda(Integer idAgenda, Date hora, Date fechaCita) {
        this.idAgenda = idAgenda;
        this.hora = hora;
        this.fechaCita = fechaCita;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }


    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Boolean getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(Boolean estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Boolean getCitaAtendida() {
        return citaAtendida;
    }

    public void setCitaAtendida(Boolean citaAtendida) {
        this.citaAtendida = citaAtendida;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }

    public Persona getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Persona idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAgenda != null ? idAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        return !((this.idAgenda == null && other.idAgenda != null) || (this.idAgenda != null && !this.idAgenda.equals(other.idAgenda)));
    }

    @Override
    public String toString() {
        return "com.erm.model.Agenda[ idAgenda=" + idAgenda + " ]";
    }
    
    
    public Agenda clonar() throws CloneNotSupportedException{
        return (Agenda) this.clone();
    }
    
    public int compararfechacita (Date fecha_comparar){
        return this.fechaCita.compareTo(fecha_comparar);
    }
}
