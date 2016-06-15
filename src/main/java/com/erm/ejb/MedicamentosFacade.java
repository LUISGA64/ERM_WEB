package com.erm.ejb;

import com.erm.model.Medicamentos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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
    
    @Override
    public Medicamentos buscarmedicamento(Medicamentos med){
        Medicamentos medicamento = null;
        String consulta;
        try{
            consulta = "FROM Medicamentos m WHERE m.atc = ?1 and m.descripcion_atc=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, med.getAtc());
            query.setParameter(2, med.getDescripcionAtc());
            
            List<Medicamentos> lista = query.getResultList();
            if(!lista.isEmpty()){
                medicamento = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return medicamento;
    }

}
