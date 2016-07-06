

package com.erm.ejb;

import com.erm.model.Agenda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;


@Stateless
public class AgendaFacade extends AbstractFacade<Agenda> implements AgendaFacadeLocal {

    @PersistenceContext(unitName = "ermPu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgendaFacade() {
        super(Agenda.class);
    }
    
    @Override
    public Agenda listarcitas (Agenda agn){
        Agenda agnd = null;
        String consulta;
        try{
            consulta = "FROM Agenda a WHERE a.id_medico =?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, agn.getIdMedico());
            
            List<Agenda> listacitas = query.getResultList();
            if(!listacitas.isEmpty()){
                agnd = listacitas.get(0);
            }
        } catch(Exception e){
            throw e;
        }
        return agnd;
    }
    
    @Override
    public Agenda turno(Agenda ag){
        Agenda agenda = null;
        String consulta;
        try
        {
            consulta = "FROM agenda a WHERE a.hora=?1 and a.id_medico=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, ag.getHora(), TemporalType.TIME);
            query.setParameter(2, ag.getIdMedico());
            
            List<Agenda> lista = query.getResultList();
            if(!lista.isEmpty()){
                agenda = lista.get(0);
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        return agenda;
    }
}
