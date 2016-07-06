package com.erm.model;

import com.erm.model.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Ocupacion.class)
public class Ocupacion_ { 

    public static volatile ListAttribute<Ocupacion, Persona> personaList;
    public static volatile SingularAttribute<Ocupacion, Integer> idocupacion;
    public static volatile SingularAttribute<Ocupacion, String> codigoOcp;
    public static volatile SingularAttribute<Ocupacion, String> descripcionOcp;

}