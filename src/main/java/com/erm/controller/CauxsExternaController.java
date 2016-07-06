
package com.erm.controller;

import com.erm.ejb.CausExternaFacadeLocal;
import com.erm.model.CausExterna;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CauxsExternaController implements Serializable{
    
    @EJB
    private CausExternaFacadeLocal cauExterFacadeLocalEJB;
    private List<CausExterna> lstcauexter;
    private CausExterna selcausext;
    
    @Inject
    private CausExterna causaexterna;
    
    @PostConstruct
    public void init(){
        lstcauexter = cauExterFacadeLocalEJB.findAll();
    }
    
    /*Metodos Setter && Getter*/

    public List<CausExterna> getLstcauexter() {
        return lstcauexter;
    }

    public void setLstcauexter(List<CausExterna> lstcauexter) {
        this.lstcauexter = lstcauexter;
    }

    public CausExterna getSelcausext() {
        return selcausext;
    }

    public void setSelcausext(CausExterna selcausext) {
        this.selcausext = selcausext;
    }

    public CausExterna getCausaexterna() {
        return causaexterna;
    }

    public void setCausaexterna(CausExterna causaexterna) {
        this.causaexterna = causaexterna;
    }
    
}
