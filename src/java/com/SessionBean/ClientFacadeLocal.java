/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SessionBean;

import com.entities.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vita_
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
    Client findByCname(String Cname);

    Boolean judgeLog(Client client);

    Boolean saveData(Client client);
    
}
