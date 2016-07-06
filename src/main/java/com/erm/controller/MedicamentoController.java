package com.erm.controller;

import com.erm.ejb.MedicamentosFacadeLocal;
import com.erm.model.FormaFarmaceutica;
import com.erm.model.Medicamentos;
import com.erm.model.UnidadMedida;
import com.erm.model.ViaAdministracion;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class MedicamentoController implements Serializable {

    @EJB
    private MedicamentosFacadeLocal medicamentosEJB;
    private List<Medicamentos> lstmedicamentos;
    private Medicamentos selmedicamentos;
    private List<Medicamentos> listarmedicamentos;

    @Inject
    private Medicamentos medicamentos;

    @Inject
    private ViaAdministracion viaadministracion;

    @Inject
    private UnidadMedida unidadmedida;

    @Inject
    private FormaFarmaceutica formafarmaceutica;

    /*  Getter && Setter */
    public List<Medicamentos> getLstmedicamentos() {
        return lstmedicamentos;
    }

    public void setLstmedicamentos(List<Medicamentos> lstmedicamentos) {
        this.lstmedicamentos = lstmedicamentos;
    }

    public Medicamentos getSelmedicamentos() {
        return selmedicamentos;
    }

    public void setSelmedicamentos(Medicamentos selmedicamentos) {
        this.selmedicamentos = selmedicamentos;
    }

    public Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ViaAdministracion getViaadministracion() {
        return viaadministracion;
    }

    public void setViaadministracion(ViaAdministracion viaadministracion) {
        this.viaadministracion = viaadministracion;
    }

    public UnidadMedida getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(UnidadMedida unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public FormaFarmaceutica getFormafarmaceutica() {
        return formafarmaceutica;
    }

    public void setFormafarmaceutica(FormaFarmaceutica formafarmaceutica) {
        this.formafarmaceutica = formafarmaceutica;
    }

    public List<Medicamentos> getListarmedicamentos() {
        return listarmedicamentos;
    }

    public void setListarmedicamentos(List<Medicamentos> listarmedicamentos) {
        this.listarmedicamentos = listarmedicamentos;
    }
    

    public void registrar() {
        try {
            medicamentosEJB.create(medicamentos);
            lstmedicamentos = medicamentosEJB.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Medicamentos", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Medicamentos", "Registro Fallo."));
        }
    }

    public void editar(RowEditEvent event) {
        try {
            Medicamentos md1 = (Medicamentos) event.getObject();
            Medicamentos md2 = medicamentosEJB.find(md1.getIdMedicamento());
            md2.setAtc(md1.getAtc());
            md2.setProducto(md1.getProducto());
            md2.setExpediente(md1.getExpediente());
            md2.setConsecutivo(md1.getConsecutivo());
            md2.setPresentacion(md1.getPresentacion());
            md2.setDescripcionAtc(md1.getDescripcionAtc());
            md2.setViaAdministracion(md1.getViaAdministracion());
            md2.setPrincipioActivo(md1.getPrincipioActivo());
            md2.setUnidadMedida(md1.getUnidadMedida());
            md2.setPos(md1.getPos());
            md2.setFormaFarmaceutica(md1.getFormaFarmaceutica());
            md2.setCum(md1.getCum());
            medicamentosEJB.edit(md2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Medicamentos", "Registro Modificado."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Medicamentos", "Cambio no realizado"));
        }
    }

    public String buscarMedicamento() {
        Medicamentos med;
        String medic = null;
        try {
            
        } catch (Exception e) {

        }
        return medic;
    }
    
    public List<Medicamentos> listarmedicamentos(){
        listarmedicamentos = medicamentosEJB.findAll();
        return listarmedicamentos;
    }
}
