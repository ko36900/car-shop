package com.LoginController;

import com.SuperClass.SuperClass;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@SessionScoped                                                          //需要在用户访问网站的整段时间内保存用户的登录状态和用户名 可转由session bean实现保存功能 
@ManagedBean(name = "login")
/**
 *
 * @author vita_
 */
public class LoginController extends SuperClass implements Serializable {

    private String username;
    private String password;
    private boolean isRemember;         //记录用户名和密码是否保存 

    public LoginController() {
    }
    
    
    
//    public String loginControl() {
//        if (judgeLog(username, password) == true) {   //需要生成后台的实例来进行
//            super.setIsLogin(true);
//            super.setUsernamePrint(username);
//            Cleaner();                     //比对完成之后选择是否清空用户名与密码
//            return "action_go.xhtml?faces-redirect=true";
//        } else {
//            super.setIsLogin(false);
//            setUsername("");
//            setPassword("");
//            RequestContext.getCurrentInstance().update("growl");    这段一定要保留 触发前台的growl部件
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "账号名或者密码输入错误"));
//            return "";
//        }
//    }
    public void Cleaner() {
        if (isRemember == true) {
        } else {
            setUsername(null);
            setPassword(null);
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
}
