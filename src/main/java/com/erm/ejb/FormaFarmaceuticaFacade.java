package com.erm.ejb;

import com.erm.model.FormaFarmaceutica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FormaFarmaceuticaFacade extends AbstractFacade<FormaFarmaceutica> implements FormaFarmaceuticaFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaFarmaceuticaFacade() {
        super(FormaFarmaceutica.class);
    }

}
