/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.TipoActividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface TipoActividadFacadeLocal {

    void create(TipoActividad tipoActividad);

    void edit(TipoActividad tipoActividad);

    void remove(TipoActividad tipoActividad);

    TipoActividad find(Object id);

    List<TipoActividad> findAll();

    List<TipoActividad> findRange(int[] range);

    int count();
    
}
