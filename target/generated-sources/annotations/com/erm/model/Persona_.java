package com.erm.model;

import com.erm.model.Agenda;
import com.erm.model.Historia;
import com.erm.model.Municipio;
import com.erm.model.NivelEducativo;
import com.erm.model.Ocupacion;
import com.erm.model.Parentesco;
import com.erm.model.TipoDoc;
import com.erm.model.UndMedida;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Ocupacion> idocupacion;
    public static volatile SingularAttribute<Persona, String> institucion;
    public static volatile ListAttribute<Persona, Agenda> agendaList;
    public static volatile SingularAttribute<Persona, String> apac2;
    public static volatile SingularAttribute<Persona, String> apac1;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> nombre1;
    public static volatile ListAttribute<Persona, Historia> historiaList;
    public static volatile SingularAttribute<Persona, NivelEducativo> idniv;
    public static volatile SingularAttribute<Persona, String> direc;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> dirac;
    public static volatile SingularAttribute<Persona, String> email;
    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile SingularAttribute<Persona, Integer> idpersona;
    public static volatile SingularAttribute<Persona, Municipio> idMunicipio;
    public static volatile SingularAttribute<Persona, String> identificacion;
    public static volatile SingularAttribute<Persona, Integer> edad;
    public static volatile SingularAttribute<Persona, String> telac;
    public static volatile SingularAttribute<Persona, Date> fechaNac;
    public static volatile SingularAttribute<Persona, String> nmac2;
    public static volatile SingularAttribute<Persona, String> nmac1;
    public static volatile SingularAttribute<Persona, Parentesco> parentesco;
    public static volatile SingularAttribute<Persona, TipoDoc> tipoDoc;
    public static volatile SingularAttribute<Persona, UndMedida> medidaEdad;
    public static volatile SingularAttribute<Persona, String> sexo;

}