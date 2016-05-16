/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erm.ejb;

import com.erm.model.Actividades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Stateless
public class ActividadesFacade extends AbstractFacade<Actividades> implements ActividadesFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadesFacade() {
        super(Actividades.class);
    }

}
