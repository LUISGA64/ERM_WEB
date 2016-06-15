
package com.erm.ejb;

import com.erm.model.Especialidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EspecialidadFacade extends AbstractFacade<Especialidad> implements EspecialidadFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialidadFacade() {
        super(Especialidad.class);
    }

}
