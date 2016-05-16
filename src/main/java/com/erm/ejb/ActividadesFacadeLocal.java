/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.Actividades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface ActividadesFacadeLocal {

    void create(Actividades actividades);

    void edit(Actividades actividades);

    void remove(Actividades actividades);

    Actividades find(Object id);

    List<Actividades> findAll();

    List<Actividades> findRange(int[] range);

    int count();
    
}
