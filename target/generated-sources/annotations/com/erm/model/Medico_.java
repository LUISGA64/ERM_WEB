package com.erm.model;

import com.erm.model.Agenda;
import com.erm.model.Especialidad;
import com.erm.model.Historia;
import com.erm.model.TipoDoc;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> apellido2;
    public static volatile SingularAttribute<Medico, Boolean> estado;
    public static volatile SingularAttribute<Medico, String> apellido1;
    public static volatile ListAttribute<Medico, Agenda> agendaList;
    public static volatile SingularAttribute<Medico, String> nombre2;
    public static volatile SingularAttribute<Medico, byte[]> firma;
    public static volatile SingularAttribute<Medico, Integer> idmedico;
    public static volatile SingularAttribute<Medico, String> nombre1;
    public static volatile SingularAttribute<Medico, Especialidad> especialidad;
    public static volatile SingularAttribute<Medico, String> registro;
    public static volatile ListAttribute<Medico, Historia> historiaList;
    public static volatile SingularAttribute<Medico, TipoDoc> tipoDoc;
    public static volatile SingularAttribute<Medico, String> ideMed;

}