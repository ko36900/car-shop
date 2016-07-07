/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyOrder;

/**
 *
 * @author vita_
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.LoginController.LoginController;

@SessionScoped
@ManagedBean(name = "product")
/**
 *
 * @author vita_
 */
public class MyOrder implements Serializable {

    private String username;
    public static String productToRender;
    public static boolean isFromMyOrder;
            
    public MyOrder() {
        username = LoginController.usernamePrint;
    }

    public String getProductToRender() {
        return productToRender;
    }

    public void setProductToRender(String productToRender) {
        this.productToRender = productToRender;
    }
    
}
