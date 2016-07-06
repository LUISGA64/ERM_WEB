package com.erm.ejb;

import com.erm.model.CausExterna;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CausExternaFacade extends AbstractFacade<CausExterna> implements CausExternaFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CausExternaFacade() {
        super(CausExterna.class);
    }

}
