/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huang.log;

/**
 *
 * @author vita_
 */
import static com.huang.log.HomePage.menuSearchTem;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "home")

public class SearchPage implements Serializable{
    private String menuSearch =menuSearchTem;
}
