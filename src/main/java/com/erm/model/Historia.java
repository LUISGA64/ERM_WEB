package com.erm.model;

import java.io.Serializable;
import java.math.BigDecimal;
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


@Entity
@Table(name = "historia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historia.findAll", query = "SELECT h FROM Historia h"),
    @NamedQuery(name = "Historia.findByIdHistoria", query = "SELECT h FROM Historia h WHERE h.idHistoria = :idHistoria"),
    @NamedQuery(name = "Historia.findByMotivoConsulta", query = "SELECT h FROM Historia h WHERE h.motivoConsulta = :motivoConsulta"),
    @NamedQuery(name = "Historia.findByEnfermedadActual", query = "SELECT h FROM Historia h WHERE h.enfermedadActual = :enfermedadActual"),
    @NamedQuery(name = "Historia.findByTemperatura", query = "SELECT h FROM Historia h WHERE h.temperatura = :temperatura"),
    @NamedQuery(name = "Historia.findByPeso", query = "SELECT h FROM Historia h WHERE h.peso = :peso"),
    @NamedQuery(name = "Historia.findByTalla", query = "SELECT h FROM Historia h WHERE h.talla = :talla"),
    @NamedQuery(name = "Historia.findByFrecuenciaCardiaca", query = "SELECT h FROM Historia h WHERE h.frecuenciaCardiaca = :frecuenciaCardiaca"),
    @NamedQuery(name = "Historia.findByPresionSistolica", query = "SELECT h FROM Historia h WHERE h.presionSistolica = :presionSistolica"),
    @NamedQuery(name = "Historia.findByPresionDiastolica", query = "SELECT h FROM Historia h WHERE h.presionDiastolica = :presionDiastolica"),
    @NamedQuery(name = "Historia.findByEvolucion", query = "SELECT h FROM Historia h WHERE h.evolucion = :evolucion")})
public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historia")
    private Integer idHistoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "motivo_consulta")
    private String motivoConsulta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "enfermedad_actual")
    private String enfermedadActual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura")
    private BigDecimal temperatura;
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "talla")
    private Integer talla;
    @Column(name = "frecuencia_cardiaca")
    private Integer frecuenciaCardiaca;
    @Column(name = "presion_sistolica")
    private Integer presionSistolica;
    @Column(name = "presion_diastolica")
    private Integer presionDiastolica;
    @Size(max = 1000)
    @Column(name = "evolucion")
    private String evolucion;
    @JoinColumn(name = "caus_externa", referencedColumnName = "id_cauxt")
    @ManyToOne
    private CausExterna causExterna;
    @JoinColumn(name = "cie10_1", referencedColumnName = "idcie10")
    @ManyToOne
    private Cie10 cie101;
    @JoinColumn(name = "cie10_2", referencedColumnName = "idcie10")
    @ManyToOne
    private Cie10 cie102;
    @JoinColumn(name = "cie10_rel", referencedColumnName = "idcie10")
    @ManyToOne
    private Cie10 cie10Rel;
    @JoinColumn(name = "id_cie10", referencedColumnName = "idcie10")
    @ManyToOne(optional = false)
    private Cie10 idCie10;
    @JoinColumn(name = "finalidad_cx", referencedColumnName = "id_finalcx")
    @ManyToOne
    private FinalCx finalidadCx;
    @JoinColumn(name = "id_medico", referencedColumnName = "idmedico")
    @ManyToOne
    private Medico idMedico;
    @JoinColumn(name = "id_paciente", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idPaciente;

    public Historia() {
    }

    public Historia(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Historia(Integer idHistoria, String motivoConsulta, String enfermedadActual) {
        this.idHistoria = idHistoria;
        this.motivoConsulta = motivoConsulta;
        this.enfermedadActual = enfermedadActual;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEnfermedadActual() {
        return enfermedadActual;
    }

    public void setEnfermedadActual(String enfermedadActual) {
        this.enfermedadActual = enfermedadActual;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public Integer getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Integer getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(Integer presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public Integer getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(Integer presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    public String getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(String evolucion) {
        this.evolucion = evolucion;
    }

    public CausExterna getCausExterna() {
        return causExterna;
    }

    public void setCausExterna(CausExterna causExterna) {
        this.causExterna = causExterna;
    }

    public Cie10 getCie101() {
        return cie101;
    }

    public void setCie101(Cie10 cie101) {
        this.cie101 = cie101;
    }

    public Cie10 getCie102() {
        return cie102;
    }

    public void setCie102(Cie10 cie102) {
        this.cie102 = cie102;
    }

    public Cie10 getCie10Rel() {
        return cie10Rel;
    }

    public void setCie10Rel(Cie10 cie10Rel) {
        this.cie10Rel = cie10Rel;
    }

    public Cie10 getIdCie10() {
        return idCie10;
    }

    public void setIdCie10(Cie10 idCie10) {
        this.idCie10 = idCie10;
    }

    public FinalCx getFinalidadCx() {
        return finalidadCx;
    }

    public void setFinalidadCx(FinalCx finalidadCx) {
        this.finalidadCx = finalidadCx;
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
        hash += (idHistoria != null ? idHistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.idHistoria == null && other.idHistoria != null) || (this.idHistoria != null && !this.idHistoria.equals(other.idHistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Historia[ idHistoria=" + idHistoria + " ]";
    }

}
