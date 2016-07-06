package com.erm.ejb;

import com.erm.model.Actividades;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ActividadesFacadeLocal {

    void create(Actividades actividades);

    void edit(Actividades actividades);

    void remove(Actividades actividades);

    Actividades find(Object id);

    List<Actividades> findAll();

    List<Actividades> findRange(int[] range);

    int count();
    
}
