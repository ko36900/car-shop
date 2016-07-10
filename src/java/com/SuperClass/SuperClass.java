/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SuperClass;

/**
 *
 * @author vita_
 */
public class SuperClass {

    protected static String usernamePrint;
    protected static boolean isLogin;
    protected static String searchText;
    protected static String menuSearch;
    protected static String productToRender;
    
    public SuperClass(){
    productToRender=menuSearch=searchText=usernamePrint=null;
    isLogin=false;    
    }

    protected static String getUsernamePrint() {
        return usernamePrint;
    }

    protected static void setUsernamePrint(String usernamePrint) {
        SuperClass.usernamePrint = usernamePrint;
    }

    protected static boolean isIsLogin() {
        return isLogin;
    }

    protected static void setIsLogin(boolean isLogin) {
        SuperClass.isLogin = isLogin;
    }

    protected static String getSearchText() {
        return searchText;
    }

    protected static void setSearchText(String searchText) {
        SuperClass.searchText = searchText;
    }

    protected static String getMenuSearch() {
        return menuSearch;
    }

    protected static void setMenuSearch(String menuSearch) {
        SuperClass.menuSearch = menuSearch;
    }

    protected static String getProductToRender() {
        return productToRender;
    }

    protected static void setProductToRender(String productToRender) {
        SuperClass.productToRender = productToRender;
    }
    
    

}
