package com.erm.model;

import com.erm.model.Menu;
import com.erm.model.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(RolMenu.class)
public class RolMenu_ { 

    public static volatile SingularAttribute<RolMenu, String> icono;
    public static volatile SingularAttribute<RolMenu, Rol> idrol;
    public static volatile SingularAttribute<RolMenu, Menu> idMenu;
    public static volatile SingularAttribute<RolMenu, Integer> idrolmenu;

}