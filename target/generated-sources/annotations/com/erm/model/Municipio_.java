package com.erm.model;

import com.erm.model.Departamento;
import com.erm.model.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile ListAttribute<Municipio, Persona> personaList;
    public static volatile SingularAttribute<Municipio, String> codigoMpio;
    public static volatile SingularAttribute<Municipio, Integer> idMunicipio;
    public static volatile SingularAttribute<Municipio, String> desMpio;
    public static volatile SingularAttribute<Municipio, Departamento> iddepartamento;

}