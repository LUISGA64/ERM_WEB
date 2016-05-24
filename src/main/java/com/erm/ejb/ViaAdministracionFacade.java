package com.erm.ejb;

import com.erm.model.ViaAdministracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ViaAdministracionFacade extends AbstractFacade<ViaAdministracion> implements ViaAdministracionFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViaAdministracionFacade() {
        super(ViaAdministracion.class);
    }

}
