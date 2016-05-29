package com.erm.ejb;

import com.erm.model.Medicamentos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MedicamentosFacadeLocal {

    void create(Medicamentos medicamentos);

    void edit(Medicamentos medicamentos);

    void remove(Medicamentos medicamentos);

    Medicamentos find(Object id);

    List<Medicamentos> findAll();

    List<Medicamentos> findRange(int[] range);

    int count();

    public Medicamentos buscarmedicamento(Medicamentos med);
    
}
