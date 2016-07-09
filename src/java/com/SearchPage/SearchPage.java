package com.SearchPage;

/**
 *
 * @author vita_
 */
import com.HomePage.HomePage;
import com.LoginController.LoginController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sun.util.logging.PlatformLogger;

@RequestScoped
@ManagedBean(name = "search")

public class SearchPage implements Serializable {

    private String username;
    private String menuSearch;
    private String searchText;
    public static String productToRender;

    public SearchPage() {

        username = LoginController.usernamePrint;
        menuSearch = HomePage.menuSearchTem;
        searchText = HomePage.searchTextTem;

//        somethings = new ArrayList<>();                       //模板代码 可以更改使用
//        SomethingOfferer=SomthingOfferer.getSomethingOfferer;
    }

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
//            System.out.println(exc);                          //应更改输出方式
//        }
//    }

    public String getMenuSearch() {
        return menuSearch;
    }

    public void setMenuSearch(String menuSearch) {
        this.menuSearch = menuSearch;
    }
        
    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        HomePage.searchTextTem = this.searchText = searchText;
    }

    public String getProductToRender() {
        return productToRender;
    }

    public void setProductToRender(String productToRender) {
        this.productToRender = productToRender;
    }

}
