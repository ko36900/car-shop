/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SessionBean;

import com.entities.Autoparts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author licihi
 */
@Stateless
public class Search implements SearchLocal {
    @PersistenceContext(unitName="testPU")
    private EntityManager em;  
    
    @Override
    public List<Autoparts> SearchResult(String autoparts_name) {
      Query q = em.createQuery("select a from Autoparts a where a.apname= :type").setParameter("type", autoparts_name);
      List<Autoparts> items = q.getResultList();
      return items;  
      
    }

    @Override
    public List<Autoparts> SpecificSingleProduct(int productID) {
      Query p = em.createQuery("select a from Autoparts a where a.apid= :id").setParameter("id", productID);
      List<Autoparts> item = p.getResultList();
      return item;  
      
    }
    
    

   
    
    
}
