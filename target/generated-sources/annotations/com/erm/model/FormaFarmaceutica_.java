package com.erm.model;

import com.erm.model.Medicamentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(FormaFarmaceutica.class)
public class FormaFarmaceutica_ { 

    public static volatile SingularAttribute<FormaFarmaceutica, String> codFormaFarma;
    public static volatile SingularAttribute<FormaFarmaceutica, String> formaFarma;
    public static volatile ListAttribute<FormaFarmaceutica, Medicamentos> medicamentosList;
    public static volatile SingularAttribute<FormaFarmaceutica, Integer> idFormaf;

}