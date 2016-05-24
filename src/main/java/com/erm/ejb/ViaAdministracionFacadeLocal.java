
package com.erm.ejb;

import com.erm.model.ViaAdministracion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ViaAdministracionFacadeLocal {

    void create(ViaAdministracion viaAdministracion);

    void edit(ViaAdministracion viaAdministracion);

    void remove(ViaAdministracion viaAdministracion);

    ViaAdministracion find(Object id);

    List<ViaAdministracion> findAll();

    List<ViaAdministracion> findRange(int[] range);

    int count();
    
}
