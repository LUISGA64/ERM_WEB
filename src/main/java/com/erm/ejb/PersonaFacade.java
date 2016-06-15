/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erm.ejb;

import com.erm.model.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    
    @Override
    public Persona obtenerpersona(Persona per) throws Exception{
        Persona persona = null;
        String consulta;
        try{
            consulta = "FROM Persona p WHERE p.identificacion =?1";
            Query q = em.createQuery(consulta);
            q.setParameter(1, per.getIdentificacion());
        }catch(Exception e){
            
        }
        return persona;
    }
    
}
