/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huang.log;

import com.huang.control.LogSessionBeanLocal;
import com.huang.log.LoginController;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean(name = "register")
/**
 *
 * @author vita_
 */
public class Register implements Serializable {

    private String username;
    private String password;
    @EJB
    private LogSessionBeanLocal usermb;

    public Register() {
        
    }

    public String registrationControl() {
        if (usermb.saveData(username, password)) {   //向数据库提交数据
            LoginController.isLogin = true;
            LoginController.usernamePrint = username;

            return "index.xhtml?faces-redirect=true";
        } else {
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error","Username or Password Invalid!!!"));
            return"";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
