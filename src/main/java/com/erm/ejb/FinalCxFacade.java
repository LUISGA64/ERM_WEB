package com.erm.ejb;

import com.erm.model.FinalCx;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FinalCxFacade extends AbstractFacade<FinalCx> implements FinalCxFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FinalCxFacade() {
        super(FinalCx.class);
    }

}
