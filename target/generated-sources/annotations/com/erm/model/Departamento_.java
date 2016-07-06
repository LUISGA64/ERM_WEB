package com.erm.model;

import com.erm.model.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> desDpto;
    public static volatile SingularAttribute<Departamento, String> codigoDpto;
    public static volatile SingularAttribute<Departamento, Integer> iddepartamento;
    public static volatile ListAttribute<Departamento, Municipio> municipioList;

}