package com.erm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona"),
    @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "Persona.findByNombre1", query = "SELECT p FROM Persona p WHERE p.nombre1 = :nombre1"),
    @NamedQuery(name = "Persona.findByNombre2", query = "SELECT p FROM Persona p WHERE p.nombre2 = :nombre2"),
    @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Persona.findByFechaNac", query = "SELECT p FROM Persona p WHERE p.fechaNac = :fechaNac"),
    @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
    @NamedQuery(name = "Persona.findByInstitucion", query = "SELECT p FROM Persona p WHERE p.institucion = :institucion"),
    @NamedQuery(name = "Persona.findByDirec", query = "SELECT p FROM Persona p WHERE p.direc = :direc"),
    @NamedQuery(name = "Persona.findByNmac1", query = "SELECT p FROM Persona p WHERE p.nmac1 = :nmac1"),
    @NamedQuery(name = "Persona.findByNmac2", query = "SELECT p FROM Persona p WHERE p.nmac2 = :nmac2"),
    @NamedQuery(name = "Persona.findByApac1", query = "SELECT p FROM Persona p WHERE p.apac1 = :apac1"),
    @NamedQuery(name = "Persona.findByApac2", query = "SELECT p FROM Persona p WHERE p.apac2 = :apac2"),
    @NamedQuery(name = "Persona.findByDirac", query = "SELECT p FROM Persona p WHERE p.dirac = :dirac"),
    @NamedQuery(name = "Persona.findByTelac", query = "SELECT p FROM Persona p WHERE p.telac = :telac"),
    @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2")})
public class Persona implements Serializable {

    @OneToMany(mappedBy = "idPaciente")
    private List<Historia> historiaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente")
    private List<Agenda> agendaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre1")
    private String nombre1;
    @Size(max = 45)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "institucion")
    private String institucion;
    @Size(max = 50)
    @Column(name = "direc")
    private String direc;
    @Size(max = 45)
    @Column(name = "nmac1")
    private String nmac1;
    @Size(max = 45)
    @Column(name = "nmac2")
    private String nmac2;
    @Size(max = 45)
    @Column(name = "apac1")
    private String apac1;
    @Size(max = 45)
    @Column(name = "apac2")
    private String apac2;
    @Size(max = 50)
    @Column(name = "dirac")
    private String dirac;
    @Size(max = 11)
    @Column(name = "telac")
    private String telac;
    @Size(max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @ManyToOne
    private Municipio idMunicipio;
    @JoinColumn(name = "idniv", referencedColumnName = "idniv")
    @ManyToOne
    private NivelEducativo idniv;
    @JoinColumn(name = "idocupacion", referencedColumnName = "idocupacion")
    @ManyToOne
    private Ocupacion idocupacion;
    @JoinColumn(name = "parentesco", referencedColumnName = "idparentesco")
    @ManyToOne
    private Parentesco parentesco;
    @JoinColumn(name = "tipo_doc", referencedColumnName = "tipodoc")
    @ManyToOne
    private TipoDoc tipoDoc;
    @JoinColumn(name = "medida_edad", referencedColumnName = "idundmedida")
    @ManyToOne
    private UndMedida medidaEdad;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Integer idpersona, String identificacion, String nombre1, String apellido1, String sexo, Date fechaNac, int edad) {
        this.idpersona = idpersona;
        this.identificacion = identificacion;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.edad = edad;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getNmac1() {
        return nmac1;
    }

    public void setNmac1(String nmac1) {
        this.nmac1 = nmac1;
    }

    public String getNmac2() {
        return nmac2;
    }

    public void setNmac2(String nmac2) {
        this.nmac2 = nmac2;
    }

    public String getApac1() {
        return apac1;
    }

    public void setApac1(String apac1) {
        this.apac1 = apac1;
    }

    public String getApac2() {
        return apac2;
    }

    public void setApac2(String apac2) {
        this.apac2 = apac2;
    }

    public String getDirac() {
        return dirac;
    }

    public void setDirac(String dirac) {
        this.dirac = dirac;
    }

    public String getTelac() {
        return telac;
    }

    public void setTelac(String telac) {
        this.telac = telac;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Municipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public NivelEducativo getIdniv() {
        return idniv;
    }

    public void setIdniv(NivelEducativo idniv) {
        this.idniv = idniv;
    }

    public Ocupacion getIdocupacion() {
        return idocupacion;
    }

    public void setIdocupacion(Ocupacion idocupacion) {
        this.idocupacion = idocupacion;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public UndMedida getMedidaEdad() {
        return medidaEdad;
    }

    public void setMedidaEdad(UndMedida medidaEdad) {
        this.medidaEdad = medidaEdad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erm.model.Persona[ idpersona=" + idpersona + " ]";
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
    
}
