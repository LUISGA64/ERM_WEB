
package com.erm.ejb;

import com.erm.model.Historia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class HistoriaFacade extends AbstractFacade<Historia> implements HistoriaFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriaFacade() {
        super(Historia.class);
    }

}
