/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SessionBean;

import com.entities.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vita_
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client findByCname(String Cname) {
        return em.find(Client.class, Cname);
    }

    @Override
    public Boolean judgeLog(Client logData_) {
        Client judgeLogdata = this.findByCname(logData_.getCname());
        //System.out.println(logData_.getPassword() + judgeLogdata.getPassword());
        return (judgeLogdata != null && judgeLogdata.getPassword().equals(logData_.getPassword()));
    }

    @Override
    public Boolean saveData(Client logData_) {
        if (logData_ == null) {
            return false;
        }
        if ((this.findByCname(logData_.getCname())) != null) {
            return false;
        }
        try {
            em.persist(logData_);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
