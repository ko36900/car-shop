/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Register;

import com.LoginController.LoginController;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "register")
/**
 *
 * @author vita_
 */
public class Register implements Serializable {

    private String username;
    private String password;

    public Register() {
    }

    public String registrationControl() {
        if (saveData(username,password)) {   //向数据库提交数据

            LoginController.isLogin = true;
            LoginController.usernamePrint = username;

            return "";
        } else {
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
