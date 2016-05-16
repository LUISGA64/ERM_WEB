/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.Municipio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface MunicipioFacadeLocal {

    void create(Municipio municipio);

    void edit(Municipio municipio);

    void remove(Municipio municipio);

    Municipio find(Object id);

    List<Municipio> findAll();

    List<Municipio> findRange(int[] range);

    int count();
    
}
