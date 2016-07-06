package com.erm.model;

import com.erm.model.CausExterna;
import com.erm.model.Cie10;
import com.erm.model.FinalCx;
import com.erm.model.Medico;
import com.erm.model.Persona;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Historia.class)
public class Historia_ { 

    public static volatile SingularAttribute<Historia, Integer> talla;
    public static volatile SingularAttribute<Historia, String> evolucion;
    public static volatile SingularAttribute<Historia, BigDecimal> peso;
    public static volatile SingularAttribute<Historia, Integer> idHistoria;
    public static volatile SingularAttribute<Historia, Medico> idMedico;
    public static volatile SingularAttribute<Historia, Integer> presionSistolica;
    public static volatile SingularAttribute<Historia, Persona> idPaciente;
    public static volatile SingularAttribute<Historia, String> motivoConsulta;
    public static volatile SingularAttribute<Historia, Integer> presionDiastolica;
    public static volatile SingularAttribute<Historia, Cie10> cie102;
    public static volatile SingularAttribute<Historia, Cie10> cie101;
    public static volatile SingularAttribute<Historia, Cie10> idCie10;
    public static volatile SingularAttribute<Historia, String> enfermedadActual;
    public static volatile SingularAttribute<Historia, BigDecimal> temperatura;
    public static volatile SingularAttribute<Historia, CausExterna> causExterna;
    public static volatile SingularAttribute<Historia, FinalCx> finalidadCx;
    public static volatile SingularAttribute<Historia, Integer> frecuenciaCardiaca;
    public static volatile SingularAttribute<Historia, Cie10> cie10Rel;

}