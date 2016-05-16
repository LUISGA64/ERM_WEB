/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.NivelEducativo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface NivelEducativoFacadeLocal {

    void create(NivelEducativo nivelEducativo);

    void edit(NivelEducativo nivelEducativo);

    void remove(NivelEducativo nivelEducativo);

    NivelEducativo find(Object id);

    List<NivelEducativo> findAll();

    List<NivelEducativo> findRange(int[] range);

    int count();
    
}
