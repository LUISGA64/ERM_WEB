package com.erm.model;

import com.erm.model.Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile SingularAttribute<Especialidad, String> descripcion;
    public static volatile SingularAttribute<Especialidad, String> codEspecialidad;
    public static volatile SingularAttribute<Especialidad, Integer> idespecialidad;
    public static volatile ListAttribute<Especialidad, Medico> medicoList;

}