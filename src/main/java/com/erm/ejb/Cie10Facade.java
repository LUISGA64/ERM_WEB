package com.erm.ejb;

import com.erm.model.Cie10;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class Cie10Facade extends AbstractFacade<Cie10> implements Cie10FacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Cie10Facade() {
        super(Cie10.class);
    }

}
