/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.TipoDoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface TipoDocFacadeLocal {

    void create(TipoDoc tipoDoc);

    void edit(TipoDoc tipoDoc);

    void remove(TipoDoc tipoDoc);

    TipoDoc find(Object id);

    List<TipoDoc> findAll();

    List<TipoDoc> findRange(int[] range);

    int count();
    
}
