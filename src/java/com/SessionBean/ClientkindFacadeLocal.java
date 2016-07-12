/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SessionBean;

import com.entities.Clientkind;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vita_
 */
@Local
public interface ClientkindFacadeLocal {

    void create(Clientkind clientkind);

    void edit(Clientkind clientkind);

    void remove(Clientkind clientkind);

    Clientkind find(Object id);

    List<Clientkind> findAll();

    List<Clientkind> findRange(int[] range);

    int count();
    
}
