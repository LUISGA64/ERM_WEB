package com.erm.ejb;

import com.erm.model.FormaFarmaceutica;
import java.util.List;
import javax.ejb.Local;


@Local
public interface FormaFarmaceuticaFacadeLocal {

    void create(FormaFarmaceutica formaFarmaceutica);

    void edit(FormaFarmaceutica formaFarmaceutica);

    void remove(FormaFarmaceutica formaFarmaceutica);

    FormaFarmaceutica find(Object id);

    List<FormaFarmaceutica> findAll();

    List<FormaFarmaceutica> findRange(int[] range);

    int count();
    
}
