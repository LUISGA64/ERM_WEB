
package com.erm.ejb;

import com.erm.model.Historia;
import java.util.List;
import javax.ejb.Local;


@Local
public interface HistoriaFacadeLocal {

    void create(Historia historia);

    void edit(Historia historia);

    void remove(Historia historia);

    Historia find(Object id);

    List<Historia> findAll();

    List<Historia> findRange(int[] range);

    int count();
    
}
