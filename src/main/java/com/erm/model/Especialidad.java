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
 * @author luisgabriel
 */
@Entity
@Table(name = "especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByIdespecialidad", query = "SELECT e FROM Especialidad e WHERE e.idespecialidad = :idespecialidad"),
    @NamedQuery(name = "Especialidad.findByCodEspecialidad", query = "SELECT e FROM Especialidad e WHERE e.codEspecialidad = :codEspecialidad"),
    @NamedQuery(name = "Especialidad.findByDescripcion", query = "SELECT e FROM Especialidad e WHERE e.descripcion = :descripcion")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespecialidad")
    private Integer idespecialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_especialidad")
    private String codEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medicoList;

    public Especialidad() {
    }

    public Especialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public Especialidad(Integer idespecialidad, String codEspecialidad, String descripcion) {
        this.idespecialidad = idespecialidad;
        this.codEspecialidad = codEspecialidad;
        this.descripcion = descripcion;
    }

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(String codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecialidad != null ? idespecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.idespecialidad == null && other.idespecialidad != null) || (this.idespecialidad != null && !this.idespecialidad.equals(other.idespecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Especialidad[ idespecialidad=" + idespecialidad + " ]";
    }
    
}
