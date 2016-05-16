/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erm.ejb;

import com.erm.model.RolMenu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Local
public interface RolMenuFacadeLocal {

    void create(RolMenu rolMenu);

    void edit(RolMenu rolMenu);

    void remove(RolMenu rolMenu);

    RolMenu find(Object id);

    List<RolMenu> findAll();

    List<RolMenu> findRange(int[] range);

    int count();
    
}
