
package com.erm.ejb;

import com.erm.model.Agenda;
import java.util.List;
import javax.ejb.Local;


@Local
public interface AgendaFacadeLocal {

    void create(Agenda agenda);

    void edit(Agenda agenda);

    void remove(Agenda agenda);

    Agenda find(Object id);

    List<Agenda> findAll();

    List<Agenda> findRange(int[] range);

    int count();

    public Agenda turno(Agenda ag);

    public Agenda listarcitas(Agenda agn);
    
}
