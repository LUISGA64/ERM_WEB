
package com.erm.ejb;

import com.erm.model.Departamento;
import java.util.List;
import javax.ejb.Local;


@Local
public interface DepartamentoFacadeLocal {

    void create(Departamento departamento);

    void edit(Departamento departamento);

    void remove(Departamento departamento);

    Departamento find(Object id);

    List<Departamento> findAll();

    List<Departamento> findRange(int[] range);

    int count();
    
}
