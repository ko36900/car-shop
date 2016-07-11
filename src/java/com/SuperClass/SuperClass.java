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
    protected static int productToRender;
    protected int totalNumberOfPages;
    protected int currentPageNumber;
    protected int[] numberOfInstancesInListOfCurrentPage;

    public SuperClass() {
        menuSearch = searchText = usernamePrint = null;
        isLogin = false;
        currentPageNumber = productToRender = totalNumberOfPages = 0;
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

    protected static int getProductToRender() {
        return productToRender;
    }

    protected static void setProductToRender(int productToRender) {
        SuperClass.productToRender = productToRender;
    }

    protected int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    protected void setTotalNumberOfPages(int totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    protected int getCurrentPageNumber() {
        return currentPageNumber;
    }

    protected void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    protected int[] getNumberOfInstancesInListOfCurrentPage() {
        return numberOfInstancesInListOfCurrentPage;
    }

    protected void setNumberOfInstancesInListOfCurrentPage(int[] numberOfInstancesInListOfCurrentPage) {
        this.numberOfInstancesInListOfCurrentPage = numberOfInstancesInListOfCurrentPage;
    }

}
