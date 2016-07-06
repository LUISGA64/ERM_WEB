
package com.erm.ejb;

import com.erm.model.FinalCx;
import java.util.List;
import javax.ejb.Local;


@Local
public interface FinalCxFacadeLocal {

    void create(FinalCx finalCx);

    void edit(FinalCx finalCx);

    void remove(FinalCx finalCx);

    FinalCx find(Object id);

    List<FinalCx> findAll();

    List<FinalCx> findRange(int[] range);

    int count();
    
}
