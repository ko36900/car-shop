/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SessionBean;

import com.entities.Clientkind;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vita_
 */
@Stateless
public class ClientkindFacade extends AbstractFacade<Clientkind> implements ClientkindFacadeLocal {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientkindFacade() {
        super(Clientkind.class);
    }
    
}
