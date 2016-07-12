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
    protected static int totalNumberOfPages;
    protected static int currentPageNumber;
    protected static int[] numberOfInstancesInListOfCurrentPage;

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

    public static int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public static void setTotalNumberOfPages(int totalNumberOfPages) {
        SuperClass.totalNumberOfPages = totalNumberOfPages;
    }

    public static int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public static void setCurrentPageNumber(int currentPageNumber) {
        SuperClass.currentPageNumber = currentPageNumber;
    }

    public static int[] getNumberOfInstancesInListOfCurrentPage() {
        return numberOfInstancesInListOfCurrentPage;
    }

    public static void setNumberOfInstancesInListOfCurrentPage(int[] numberOfInstancesInListOfCurrentPage) {
        SuperClass.numberOfInstancesInListOfCurrentPage = numberOfInstancesInListOfCurrentPage;
    }

}
