package com.erm.model;

import com.erm.model.Medicamentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(ViaAdministracion.class)
public class ViaAdministracion_ { 

    public static volatile SingularAttribute<ViaAdministracion, Integer> idVia;
    public static volatile ListAttribute<ViaAdministracion, Medicamentos> medicamentosList;
    public static volatile SingularAttribute<ViaAdministracion, String> codVia;
    public static volatile SingularAttribute<ViaAdministracion, String> descripcioVia;

}