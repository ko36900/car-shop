package com.SearchPage;

/**
 *
 * @author vita_
 */
import com.SuperClass.SuperClass;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sun.util.logging.PlatformLogger;

@RequestScoped
@ManagedBean(name = "search")

public class SearchPage extends SuperClass implements Serializable {

    private String username;
    private String menuSearchTem;
    private String searchTextTem;
    private int productToRenderTem;

    public SearchPage() {

//        username = LoginController.getUsernamePrint();
        menuSearchTem = super.getMenuSearch();
        searchTextTem = super.getSearchText();
        setUsernameFromSuperClass();

//        somethings = new ArrayList<>();                       //模板代码 可以更改使用
//        SomethingOfferer=SomthingOfferer.getSomethingOfferer;
    }

    public void setUsernameFromSuperClass() {
        setUsername(super.getUsernamePrint());
    }

//     private List<Something> somethings;
//     private SomethingOfferer SomethingOfferer; 
//    public void loadSomething(List<Something>) {
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
    public String getMenuSearchTem() {
        return menuSearchTem;
    }

    public void setMenuSearchTem(String menuSearchTem) {
        this.menuSearchTem = menuSearchTem;
    }

    public String getSearchTextTem() {
        return searchTextTem;
    }

    public void setSearchTextTem(String searchTextTem) {
        this.searchTextTem = searchTextTem;
    }

    public int getProductToRenderTem() {
        return productToRenderTem;
    }

    public void setProductToRenderTem(int productToRenderTem) {
        this.productToRenderTem = productToRenderTem;
        super.setProductToRender(productToRenderTem);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
