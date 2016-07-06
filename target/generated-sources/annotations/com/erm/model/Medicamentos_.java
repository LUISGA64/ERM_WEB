package com.erm.model;

import com.erm.model.FormaFarmaceutica;
import com.erm.model.UnidadMedida;
import com.erm.model.ViaAdministracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Medicamentos.class)
public class Medicamentos_ { 

    public static volatile SingularAttribute<Medicamentos, Integer> idMedicamento;
    public static volatile SingularAttribute<Medicamentos, String> principioActivo;
    public static volatile SingularAttribute<Medicamentos, String> descripcionAtc;
    public static volatile SingularAttribute<Medicamentos, String> expediente;
    public static volatile SingularAttribute<Medicamentos, UnidadMedida> unidadMedida;
    public static volatile SingularAttribute<Medicamentos, ViaAdministracion> viaAdministracion;
    public static volatile SingularAttribute<Medicamentos, String> presentacion;
    public static volatile SingularAttribute<Medicamentos, String> producto;
    public static volatile SingularAttribute<Medicamentos, String> consecutivo;
    public static volatile SingularAttribute<Medicamentos, String> atc;
    public static volatile SingularAttribute<Medicamentos, Boolean> pos;
    public static volatile SingularAttribute<Medicamentos, String> cum;
    public static volatile SingularAttribute<Medicamentos, FormaFarmaceutica> formaFarmaceutica;

}