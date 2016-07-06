package com.erm.model;

import com.erm.model.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Parentesco.class)
public class Parentesco_ { 

    public static volatile SingularAttribute<Parentesco, String> codpar;
    public static volatile SingularAttribute<Parentesco, String> parentesco;
    public static volatile ListAttribute<Parentesco, Persona> personaList;
    public static volatile SingularAttribute<Parentesco, Integer> idparentesco;

}