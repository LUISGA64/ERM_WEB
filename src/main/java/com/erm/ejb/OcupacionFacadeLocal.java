/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.Ocupacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface OcupacionFacadeLocal {

    void create(Ocupacion ocupacion);

    void edit(Ocupacion ocupacion);

    void remove(Ocupacion ocupacion);

    Ocupacion find(Object id);

    List<Ocupacion> findAll();

    List<Ocupacion> findRange(int[] range);

    int count();
    
}
