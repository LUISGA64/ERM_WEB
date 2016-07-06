package com.erm.model;

import com.erm.model.Medico;
import com.erm.model.Persona;
import com.erm.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(TipoDoc.class)
public class TipoDoc_ { 

    public static volatile ListAttribute<TipoDoc, Usuario> usuarioList;
    public static volatile ListAttribute<TipoDoc, Persona> personaList;
    public static volatile SingularAttribute<TipoDoc, Integer> tipodoc;
    public static volatile SingularAttribute<TipoDoc, String> documento;
    public static volatile SingularAttribute<TipoDoc, String> codoc;
    public static volatile ListAttribute<TipoDoc, Medico> medicoList;

}