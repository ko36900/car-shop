/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SearchPage;

/**
 *
 * @author vita_
 */
import com.HomePage.HomePage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sun.util.logging.PlatformLogger;

@SessionScoped
@ManagedBean(name = "search")

public class SearchPage implements Serializable {

    private String menuSearch;
    private String searchText;
    public static boolean isFromSearchPage;
    public static String productToRender;

    public SearchPage() {

        menuSearch = HomePage.menuSearchTem;
        searchText = HomePage.searchTextTem;

//        somethings = new ArrayList<>();
//        SomethingOfferer=SomthingOfferer.getSomethingOfferer;
    }
//
//     private List<Something> somethings;
//     private SomethingOfferer SomethingOfferer; 

//    public void loadSomething() {
//
//        Logger.info("Loading Something");
//
//        something.clear();
//
//        try {
//
//            somethings = SomethingOfferer.getsomething();
//        } catch (Exception exc) {
//
//            logger.log(Level.SEVERE, "Error when loading something", exc);
//
//            System.out.println(exc);
//        }
//    }
    public String getProductToRender() {
        return productToRender;
    }

    public void setProductToRender(String productToRender) {
        this.productToRender = productToRender;
    }

}
