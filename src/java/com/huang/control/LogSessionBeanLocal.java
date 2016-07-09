/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huang.control;

import com.huang.log.LogData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author huang
 */
@Local
public interface LogSessionBeanLocal {

    LogData searchData(String userName);

    List<LogData> getAll();

    Boolean judgeLog(String userName, String password);

    Boolean saveData(String userName, String password);

   
    
}
