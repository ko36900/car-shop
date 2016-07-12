/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SessionBean;

import com.entities.Autoparts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author licihi
 */
@Local
public interface SearchLocal {

    List<Autoparts> SearchResult(String autoparts_name);

    List<Autoparts> SpecificSingleProduct(int productID);
}
