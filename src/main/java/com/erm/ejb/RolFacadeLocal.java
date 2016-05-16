
package com.erm.ejb;

import com.erm.model.Rol;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RolFacadeLocal {

    void create(Rol rol);

    void edit(Rol rol);

    void remove(Rol rol);

    Rol find(Object id);

    List<Rol> findAll();

    List<Rol> findRange(int[] range);

    int count();
    
}
