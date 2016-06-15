
package com.erm.ejb;

import com.erm.model.Turno;
import java.util.List;
import javax.ejb.Local;


@Local
public interface TurnoFacadeLocal {

    void create(Turno turno);

    void edit(Turno turno);

    void remove(Turno turno);

    Turno find(Object id);

    List<Turno> findAll();

    List<Turno> findRange(int[] range);

    int count();
    
}
