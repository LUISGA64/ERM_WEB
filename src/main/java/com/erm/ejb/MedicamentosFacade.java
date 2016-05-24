package com.erm.ejb;

import com.erm.model.Medicamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MedicamentosFacade extends AbstractFacade<Medicamentos> implements MedicamentosFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicamentosFacade() {
        super(Medicamentos.class);
    }

}
