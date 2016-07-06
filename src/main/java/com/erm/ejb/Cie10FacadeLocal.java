
package com.erm.ejb;

import com.erm.model.Cie10;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Cie10FacadeLocal {

    void create(Cie10 cie10);

    void edit(Cie10 cie10);

    void remove(Cie10 cie10);

    Cie10 find(Object id);

    List<Cie10> findAll();

    List<Cie10> findRange(int[] range);

    int count();
    
}
