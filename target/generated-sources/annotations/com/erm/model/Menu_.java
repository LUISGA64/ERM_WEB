package com.erm.model;

import com.erm.model.Menu;
import com.erm.model.RolMenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T22:54:41")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, Character> tipMenu;
    public static volatile ListAttribute<Menu, RolMenu> rolMenuList;
    public static volatile SingularAttribute<Menu, Menu> idMenu;
    public static volatile SingularAttribute<Menu, Integer> idmenu;
    public static volatile SingularAttribute<Menu, String> detMenu;

}