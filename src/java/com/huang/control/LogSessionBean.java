/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huang.control;

import javax.ejb.Stateless;
import com.huang.log.LogData;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
/**
 *
 * @author huang
 */
@Stateless
public class LogSessionBean implements LogSessionBeanLocal {
    @PersistenceContext(unitName="smallTerm1PU")
    private EntityManager em;
   
    @Override
    public LogData searchData(String userName) {
        return em.find(LogData.class, userName);
    }
    
    @Override
    public List<LogData> getAll() {
        return em.createQuery("select * from LogData as l").getResultList();
    }

    @Override
    public Boolean judgeLog(String userName, String password) {
        LogData l=searchData(userName);
        if (l==null)
            return false;
        else if(l.getSecrectWord().equals(password))
            return true;
        else return false;
    }

    @Override
    public Boolean saveData(String userName, String password) {
            LogData alter=new LogData();
            alter.setUserName(userName);
            alter.setSecrectWord(password);
            LogData l=searchData(userName);
            if (l!=null)
                return false;
            try{
                em.persist(alter);                    
                }
            catch (Exception e){
                return false;
            }
            return true;
    }
   }
