package com.erm.ejb;

import com.erm.model.CausExterna;
import java.util.List;
import javax.ejb.Local;


@Local
public interface CausExternaFacadeLocal {

    void create(CausExterna causExterna);

    void edit(CausExterna causExterna);

    void remove(CausExterna causExterna);

    CausExterna find(Object id);

    List<CausExterna> findAll();

    List<CausExterna> findRange(int[] range);

    int count();
    
}
