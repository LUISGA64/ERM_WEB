package com.erm.model;

import com.erm.model.Medico;
import com.erm.model.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile SingularAttribute<Agenda, Persona> idPaciente;
    public static volatile SingularAttribute<Agenda, Date> fechaCita;
    public static volatile SingularAttribute<Agenda, Boolean> estadoCita;
    public static volatile SingularAttribute<Agenda, Date> hora;
    public static volatile SingularAttribute<Agenda, Integer> idAgenda;
    public static volatile SingularAttribute<Agenda, Boolean> citaAtendida;
    public static volatile SingularAttribute<Agenda, Medico> idMedico;

}