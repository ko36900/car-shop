/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LoginController;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "login")
/**
 *
 * @author vita_
 */
public class LoginController implements Serializable {

    private String username;
    public static String usernamePrint;
    private String password;
    private boolean isRemember;         //记录用户名和密码是否保存 
    public static boolean isLogin;            //记录用户是否处于登陆状态

    public LoginController() {
    }

    public String returnUsername() {
        if (isLogin == true) {
            return usernamePrint;
        }
        return "";
    }

//    public String loginControl() {
//        if (judgeLog(username, password) == true) {   //需要生成后台的实例来进行
//            setIsLogin(true);
//            setUsernamePrint(username);
//            Cleaner();                     //比对完成之后选择是否清空用户名与密码
//            return "index.xhtml?faces-redirect=true";
//        } else {
//            setIsLogin(false);
//            setUsername("");
//            setPassword("");
//            RequestContext.getCurrentInstance().update("growl");
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "账号名或者密码输入错误"));
//            return "";
//        }
//    }
    public void Cleaner() {
        if (isRemember == true) {
        } else {
            setUsername("");
            setPassword("");
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

    public boolean isIsRemember() {
        return isRemember;
    }

    public void setIsRemember(boolean isRemember) {
        this.isRemember = isRemember;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getUsernamePrint() {
        return usernamePrint;
    }

    public void setUsernamePrint(String usernamePrint) {
        this.usernamePrint = usernamePrint;
    }
}
