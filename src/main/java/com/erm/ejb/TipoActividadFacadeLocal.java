
package com.erm.ejb;

import com.erm.model.TipoActividad;
import java.util.List;
import javax.ejb.Local;


@Local
public interface TipoActividadFacadeLocal {

    void create(TipoActividad tipoActividad);

    void edit(TipoActividad tipoActividad);

    void remove(TipoActividad tipoActividad);

    TipoActividad find(Object id);

    List<TipoActividad> findAll();

    List<TipoActividad> findRange(int[] range);

    int count();
    
}
