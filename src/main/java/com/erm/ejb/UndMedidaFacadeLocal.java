/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.UndMedida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface UndMedidaFacadeLocal {

    void create(UndMedida undMedida);

    void edit(UndMedida undMedida);

    void remove(UndMedida undMedida);

    UndMedida find(Object id);

    List<UndMedida> findAll();

    List<UndMedida> findRange(int[] range);

    int count();
    
}
