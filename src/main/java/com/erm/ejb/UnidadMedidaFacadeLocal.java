
package com.erm.ejb;

import com.erm.model.UnidadMedida;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UnidadMedidaFacadeLocal {

    void create(UnidadMedida unidadMedida);

    void edit(UnidadMedida unidadMedida);

    void remove(UnidadMedida unidadMedida);

    UnidadMedida find(Object id);

    List<UnidadMedida> findAll();

    List<UnidadMedida> findRange(int[] range);

    int count();
    
}
